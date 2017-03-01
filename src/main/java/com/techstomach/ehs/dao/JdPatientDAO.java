package com.techstomach.ehs.dao;

import com.techstomach.ehs.core.JdPatient;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by ujjwal on 3/2/2017.
 */
public class JdPatientDAO extends AbstractDAO<JdPatient> {

    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    public JdPatientDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<JdPatient> getAll() {
        return (List<JdPatient>) currentSession().createCriteria(JdPatient.class).list();
    }

    public JdPatient findById(long id) {
        return currentSession().get(JdPatient.class, id);
    }

    public void delete(JdPatient jdPatient) {
        currentSession().delete(jdPatient);
    }

    public void update(JdPatient jdPatient) {
        currentSession().saveOrUpdate(jdPatient);
    }

    public JdPatient insert(JdPatient jdPatient) {
        return persist(jdPatient);
    }
}
