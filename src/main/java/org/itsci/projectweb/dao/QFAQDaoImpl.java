package org.itsci.projectweb.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.itsci.projectweb.model.AFAQ;
import org.itsci.projectweb.model.QFAQ;
import org.itsci.projectweb.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class QFAQDaoImpl implements QFAQDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveQFAQ(QFAQ qfaq) {
        Session session = sessionFactory.getCurrentSession();
        session.save(qfaq);
    }

    @Override
    public void deleteQFAQ(QFAQ qfaq) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(qfaq);
    }

    @Override
    public QFAQ getQFAQById(int qfaqId) {
        Session session = sessionFactory.getCurrentSession();
        Query<QFAQ> query = session.createQuery("FROM QFAQ q WHERE q.qfaq_id =: qId", QFAQ.class);
        query.setParameter("qId", qfaqId);
        return query.getSingleResult();
    }

    @Override
    public void updateQFAQ(QFAQ qfaq) {
        Session session = sessionFactory.getCurrentSession();
        session.update(qfaq);
    }

    @Override
    public List<QFAQ> getQFAQByQFAQName(String qfaq_name) {
        Session session = sessionFactory.getCurrentSession();
        Query<QFAQ> query = session.createQuery("FROM QFAQ q WHERE q.qfaq_name LIKE :qName", QFAQ.class);
        query.setParameter("qName", "%" + qfaq_name + "%");
        return query.getResultList();
    }

    @Override
    public List<QFAQ> CheckWords(String words) {
        Session session = sessionFactory.getCurrentSession();
        Query<QFAQ> query = session.createQuery("FROM QFAQ q WHERE q.qfaq_name = :qqt", QFAQ.class);
        query.setParameter("qqt", words);
        return query.getResultList();
    }
}
