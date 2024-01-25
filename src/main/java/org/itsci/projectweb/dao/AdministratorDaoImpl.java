package org.itsci.projectweb.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.itsci.projectweb.model.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdministratorDaoImpl implements AdministratorDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Administrator> getAdministrators() {
        Session session = sessionFactory.getCurrentSession();
        Query<Administrator> query = session.createQuery("FROM Administrator", Administrator.class);
        return query.getResultList();
    }

    @Override
    public Administrator getAdministratorByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query<Administrator> query = session.createQuery("FROM Administrator a WHERE a.username =: userName", Administrator.class);
        query.setParameter("userName", username);
        return query.getSingleResult();
    }
}
