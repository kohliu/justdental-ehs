package com.techstomach.ehs.dao;

import com.techstomach.ehs.core.JdBookingSlots;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by ujjwal on 3/2/2017.
 */
public class JdBookingSlotsDAO extends AbstractDAO<JdBookingSlots> {


    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    public JdBookingSlotsDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<JdBookingSlots> getAll() {
        return (List<JdBookingSlots>) currentSession().createCriteria(JdBookingSlots.class).list();
    }

    public JdBookingSlots findById(long id) {
        return currentSession().get(JdBookingSlots.class, id);
    }

    public void delete(JdBookingSlots jdBookingSlots) {
        currentSession().delete(jdBookingSlots);
    }

    public void update(JdBookingSlots jdBookingSlots) {
        currentSession().saveOrUpdate(jdBookingSlots);
    }

    public JdBookingSlots insert(JdBookingSlots jdBookingSlots) {
        return persist(jdBookingSlots);
    }
}
