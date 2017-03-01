package com.techstomach.ehs.dao;

import com.techstomach.ehs.core.JdClinicRoleMap;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by ujjwal on 3/2/2017.
 */
public class JdClinicRoleMapDAO extends AbstractDAO<JdClinicRoleMap>{

    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    public JdClinicRoleMapDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<JdClinicRoleMap> getAll() {
        return (List<JdClinicRoleMap>) currentSession().createCriteria(JdClinicRoleMap.class).list();
    }

    public JdClinicRoleMap findById(long id) {
        return currentSession().get(JdClinicRoleMap.class, id);
    }

    public void delete(JdClinicRoleMap jdClinicRoleMap) {
        currentSession().delete(jdClinicRoleMap);
    }

    public void update(JdClinicRoleMap jdClinicRoleMap) {
        currentSession().saveOrUpdate(jdClinicRoleMap);
    }

    public JdClinicRoleMap insert(JdClinicRoleMap jdClinicRoleMap) {
        return persist(jdClinicRoleMap);
    }
}
