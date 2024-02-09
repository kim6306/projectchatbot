package org.itsci.projectweb.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.itsci.projectweb.model.AFAQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AFAQDaoImpl implements AFAQDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void deleteAFAQ(AFAQ afaq) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(afaq);
    }

    @Override
    public void updateAFAQ(AFAQ afaq) {
        Session session = sessionFactory.getCurrentSession();
        session.update(afaq);
    }

    @Override
    public void saveAFAQ(AFAQ afaq) {
        Session session = sessionFactory.getCurrentSession();
        session.save(afaq);
    }

    @Override
    public AFAQ getAFAQById(int afaqId) {
        Session session = sessionFactory.getCurrentSession();
        Query<AFAQ> query = session.createQuery("FROM AFAQ a WHERE a.afaq_id =: aId", AFAQ.class);
        query.setParameter("aId", afaqId);
        return query.getSingleResult();
    }

    @Override
    public List<AFAQ> CheckWords(String words) {
        Session session = sessionFactory.getCurrentSession();
        Query<AFAQ> query = session.createQuery("FROM AFAQ a WHERE a.afaq_name = :aqt", AFAQ.class);
        query.setParameter("aqt", words);
        return query.getResultList();
    }
}
