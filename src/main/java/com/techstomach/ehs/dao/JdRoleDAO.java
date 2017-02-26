package com.techstomach.ehs.dao;

import com.techstomach.ehs.core.JdRole;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by ujjwal on 2/24/2017.
 */
public class JdRoleDAO extends AbstractDAO<JdRole> {

    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    public JdRoleDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<JdRole> getAll() {
        return (List<JdRole>) currentSession().createCriteria(JdRole.class).list();
    }

    public JdRole findById(long id) {
        return currentSession().get(JdRole.class, id);
    }

    public void delete(JdRole jdRole) {
        currentSession().delete(jdRole);
    }

    public void update(JdRole jdRole) {
        currentSession().saveOrUpdate(jdRole);
    }

    public JdRole insert(JdRole jdRole) {
        return persist(jdRole);
    }
}
