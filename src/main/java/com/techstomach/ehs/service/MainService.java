/*
 * Copyright (c) 2017 Techstomach (TM)
 *
 * This software is an intellectual property of Techstomach Solutions Pvt Ltd,India.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.techstomach.ehs.service;

import com.techstomach.ehs.core.appointment.JdAppointment;
import com.techstomach.ehs.core.appointment.JdBookingSlots;
import com.techstomach.ehs.core.clinic.JdClinic;
import com.techstomach.ehs.core.clinic.JdClinicRoleMap;
import com.techstomach.ehs.core.login.JdLoginTracking;
import com.techstomach.ehs.core.login.JdNativeLogin;
import com.techstomach.ehs.core.login.JdSsoLogin;
import com.techstomach.ehs.core.role.JdRole;
import com.techstomach.ehs.core.role.RoleType;
import com.techstomach.ehs.core.subscribe.JdSubscription;
import com.techstomach.ehs.core.user.JdUser;
import com.techstomach.ehs.core.user.patient.JdPatient;
import com.techstomach.ehs.dao.appointment.JdAppointmentDAO;
import com.techstomach.ehs.dao.appointment.JdBookingSlotsDAO;
import com.techstomach.ehs.dao.clinic.JdClinicDAO;
import com.techstomach.ehs.dao.clinic.JdClinicRoleMapDAO;
import com.techstomach.ehs.dao.login.JdLoginTrackingDAO;
import com.techstomach.ehs.dao.login.JdNativeLoginDAO;
import com.techstomach.ehs.dao.login.JdSsoLoginDAO;
import com.techstomach.ehs.dao.role.JdRoleDAO;
import com.techstomach.ehs.dao.subscribe.JdSubscriptionDAO;
import com.techstomach.ehs.dao.user.JdUserDAO;
import com.techstomach.ehs.dao.user.patient.JdPatientDAO;
import com.techstomach.ehs.resources.appointment.JdAppointmentResource;
import com.techstomach.ehs.resources.appointment.JdBookingSlotsResource;
import com.techstomach.ehs.resources.clinic.JdClinicResource;
import com.techstomach.ehs.resources.clinic.JdClinicRoleMapResource;
import com.techstomach.ehs.resources.login.JdLoginTrackingResource;
import com.techstomach.ehs.resources.login.JdNativeLoginResource;
import com.techstomach.ehs.resources.login.JdSsoLoginResource;
import com.techstomach.ehs.resources.role.JdRoleResource;
import com.techstomach.ehs.resources.subscribe.JdSubscriptionResource;
import com.techstomach.ehs.resources.user.patient.JdPatientResource;
import com.techstomach.ehs.resources.user.JdUserResource;
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
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.skife.jdbi.v2.DBI;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

public class MainService extends Application<ServiceConfiguration> {

    private final HibernateBundle<ServiceConfiguration> hibernate = new HibernateBundle<ServiceConfiguration>
            (
                    JdRole.class,
                    RoleType.class,
                    JdUser.class,
                    JdPatient.class,
                    JdNativeLogin.class,
                    JdSsoLogin.class,
                    JdLoginTracking.class,
                    JdClinic.class,
                    JdAppointment.class,
                    JdBookingSlots.class,
                    JdClinicRoleMap.class,
                    JdSubscription.class
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

//        bootstrap.addBundle(new RedirectBundle(
//                new HttpsRedirect()
//        ));
        bootstrap.addBundle(new MigrationsBundle<ServiceConfiguration>() {
            @Override
            public PooledDataSourceFactory getDataSourceFactory(final ServiceConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
        bootstrap.addBundle(new AssetsBundle("/assets/", "/", "/index.html"));
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

        // Enable CORS headers
        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        cors.setInitParameter("allowedOrigins", "*");
        //cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedHeaders", "*");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

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

        final JdClinicRoleMapDAO jdClinicRoleMapDAO = new JdClinicRoleMapDAO(hibernate.getSessionFactory());
        final JdClinicRoleMapResource jdClinicRoleMapResource = new JdClinicRoleMapResource(jdClinicRoleMapDAO);
        environment.jersey().register(jdClinicRoleMapResource);

        final JdBookingSlotsDAO jdBookingSlotsDAO = new JdBookingSlotsDAO(hibernate.getSessionFactory());
        final JdBookingSlotsResource jdBookingSlotsResource = new JdBookingSlotsResource(jdBookingSlotsDAO);
        environment.jersey().register(jdBookingSlotsResource);

        final JdAppointmentDAO jdAppointmentDAO = new JdAppointmentDAO(hibernate.getSessionFactory());
        final JdAppointmentResource jdAppointmentResource = new JdAppointmentResource(jdAppointmentDAO);
        environment.jersey().register(jdAppointmentResource);

        final JdPatientDAO jdPatientDAO = new JdPatientDAO(hibernate.getSessionFactory());
        final JdPatientResource jdPatientResource = new JdPatientResource(jdPatientDAO);
        environment.jersey().register(jdPatientResource);

        final JdSubscriptionDAO jdSubscriptionDAO = new JdSubscriptionDAO(hibernate.getSessionFactory());
        final JdSubscriptionResource jdSubscriptionResource = new JdSubscriptionResource(jdSubscriptionDAO);
        environment.jersey().register(jdSubscriptionResource);

        environment.healthChecks().register("health",
                new DatabaseHealthCheck(jdbi, configuration.getDataSourceFactory().getValidationQuery()));


    }

}

