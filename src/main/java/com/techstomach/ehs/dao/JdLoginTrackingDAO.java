package com.techstomach.ehs.dao;

import com.techstomach.ehs.core.JdLoginTracking;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by ujjwal on 2/25/2017.
 */
public class JdLoginTrackingDAO extends AbstractDAO<JdLoginTracking> {

    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    public JdLoginTrackingDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<JdLoginTracking> getAll() {
        return (List<JdLoginTracking>) currentSession().createCriteria(JdLoginTracking.class).list();
    }

    public JdLoginTracking findById(long id) {
        return currentSession().get(JdLoginTracking.class, id);
    }

    public void delete(JdLoginTracking jdLoginTracking) {
        currentSession().delete(jdLoginTracking);
    }

    public void update(JdLoginTracking jdLoginTracking) {
        currentSession().saveOrUpdate(jdLoginTracking);
    }

    public JdLoginTracking insert(JdLoginTracking jdLoginTracking) {
        return persist(jdLoginTracking);
    }
}
