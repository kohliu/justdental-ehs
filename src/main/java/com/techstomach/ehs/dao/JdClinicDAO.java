package com.techstomach.ehs.dao;

import com.techstomach.ehs.core.JdClinic;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by ujjwal on 2/25/2017.
 */
public class JdClinicDAO extends AbstractDAO<JdClinic>{

    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    public JdClinicDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<JdClinic> getAll() {
        return (List<JdClinic>) currentSession().createCriteria(JdClinic.class).list();
    }

    public JdClinic findById(long id) {
        return currentSession().get(JdClinic.class, id);
    }

    public void delete(JdClinic jdClinic) {
        currentSession().delete(jdClinic);
    }

    public void update(JdClinic jdClinic) {
        currentSession().saveOrUpdate(jdClinic);
    }

    public JdClinic insert(JdClinic jdClinic) {
        return persist(jdClinic);
    }
}
