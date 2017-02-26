package com.techstomach.ehs.service.health;

import com.codahale.metrics.health.HealthCheck;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

/**
 * Created by ujjwal on 2/24/2017.
 */
public class DatabaseHealthCheck extends HealthCheck {

    private final DBI dbi;
    private final String validationQuery;

    public DatabaseHealthCheck(DBI dbi, String validationQuery) {
        this.dbi = dbi;
        this.validationQuery = validationQuery;
    }

    @Override
    protected Result check() {

        try {
            final Handle handle = dbi.open();

            handle.execute(validationQuery);

            handle.close();
        } catch (Exception e) {
            return Result.unhealthy("Database is not running!");
        }

        return Result.healthy();
    }
}

