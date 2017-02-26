package com.techstomach.ehs.dao;

import com.techstomach.ehs.core.JdNativeLogin;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by ujjwal on 2/25/2017.
 */
public class JdNativeLoginDAO extends AbstractDAO<JdNativeLogin> {

    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    public JdNativeLoginDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<JdNativeLogin> getAll() {
        return (List<JdNativeLogin>) currentSession().createCriteria(JdNativeLogin.class).list();
    }

    public JdNativeLogin findById(long id) {
        return currentSession().get(JdNativeLogin.class, id);
    }

    public void delete(JdNativeLogin jdNativeLogin) {
        currentSession().delete(jdNativeLogin);
    }

    public void update(JdNativeLogin jdNativeLogin) {
        currentSession().saveOrUpdate(jdNativeLogin);
    }

    public JdNativeLogin insert(JdNativeLogin jdNativeLogin) {
        return persist(jdNativeLogin);
    }
}
