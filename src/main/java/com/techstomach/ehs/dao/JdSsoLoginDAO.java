package com.techstomach.ehs.dao;

import com.techstomach.ehs.core.JdSsoLogin;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by ujjwal on 2/25/2017.
 */
public class JdSsoLoginDAO extends AbstractDAO<JdSsoLogin> {

    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    public JdSsoLoginDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }


    public List<JdSsoLogin> getAll() {
        return (List<JdSsoLogin>) currentSession().createCriteria(JdSsoLogin.class).list();
    }

    public JdSsoLogin findById(long id) {
        return currentSession().get(JdSsoLogin.class, id);
    }

    public void delete(JdSsoLogin jdSsoLogin) {
        currentSession().delete(jdSsoLogin);
    }

    public void update(JdSsoLogin jdSsoLogin) {
        currentSession().saveOrUpdate(jdSsoLogin);
    }

    public JdSsoLogin insert(JdSsoLogin jdSsoLogin) {
        return persist(jdSsoLogin);
    }
}
