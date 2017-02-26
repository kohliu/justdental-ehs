package com.techstomach.ehs.service;

import com.techstomach.ehs.core.*;
import com.techstomach.ehs.dao.*;
import com.techstomach.ehs.resources.*;
import com.techstomach.ehs.service.health.DatabaseHealthCheck;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.skife.jdbi.v2.DBI;

/**
 * Created by ujjwal on 2/24/2017.
 */
public class MainService extends Application<ServiceConfiguration> {

    private final HibernateBundle<ServiceConfiguration> hibernate = new HibernateBundle<ServiceConfiguration>
            (
                    JdRole.class,
                    JdUser.class,
                    JdNativeLogin.class,
                    JdSsoLogin.class,
                    JdLoginTracking.class,
                    JdClinic.class
            ) {
        @Override
        public DataSourceFactory getDataSourceFactory(ServiceConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    public static void main(String[] args) throws Exception {
        new MainService().run(args);
    }

    @Override
    public void initialize(Bootstrap<ServiceConfiguration> bootstrap) {
        bootstrap.addBundle(new MigrationsBundle<ServiceConfiguration>() {
            @Override
            public PooledDataSourceFactory getDataSourceFactory(final ServiceConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
        bootstrap.addBundle(new AssetsBundle("/assets/","/","/home-version-2.html"));
        bootstrap.addBundle(hibernate);
        bootstrap.addBundle(new SwaggerBundle<ServiceConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(ServiceConfiguration configuration) {
                return configuration.swaggerBundleConfiguration;
            }
        });
    }

    @Override
    public void run(ServiceConfiguration configuration, Environment environment) throws Exception {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");
        environment.jersey().setUrlPattern("/api/*");

        final JdRoleDAO jdRoleDAO = new JdRoleDAO(hibernate.getSessionFactory());
        final JdRoleResource jdRoleResource = new JdRoleResource(jdRoleDAO);
        environment.jersey().register(jdRoleResource);

        final JdUserDAO jdUserDAO = new JdUserDAO(hibernate.getSessionFactory());
        final JdUserResource jdUserResource = new JdUserResource(jdUserDAO);
        environment.jersey().register(jdUserResource);

        final JdNativeLoginDAO jdNativeLoginDAO = new JdNativeLoginDAO(hibernate.getSessionFactory());
        final JdNativeLoginResource jdNativeLoginResource = new JdNativeLoginResource(jdNativeLoginDAO);
        environment.jersey().register(jdNativeLoginResource);

        final JdSsoLoginDAO jdSsoLoginDAO = new JdSsoLoginDAO(hibernate.getSessionFactory());
        final JdSsoLoginResource jdSsoLoginResource = new JdSsoLoginResource(jdSsoLoginDAO);
        environment.jersey().register(jdSsoLoginResource);

        final JdLoginTrackingDAO jdLoginTrackingDAO = new JdLoginTrackingDAO(hibernate.getSessionFactory());
        final JdLoginTrackingResource jdLoginTrackingReource = new JdLoginTrackingResource(jdLoginTrackingDAO);
        environment.jersey().register(jdLoginTrackingReource);

        final JdClinicDAO jdClinicDAO = new JdClinicDAO(hibernate.getSessionFactory());
        final JdClinicResource jdClinicResource = new JdClinicResource(jdClinicDAO);
        environment.jersey().register(jdClinicResource);

        environment.healthChecks().register("health",
                new DatabaseHealthCheck(jdbi, configuration.getDataSourceFactory().getValidationQuery()));


    }

}

