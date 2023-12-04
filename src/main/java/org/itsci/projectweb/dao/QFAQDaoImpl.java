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
    public List<QFAQ> getQFAQs() {
        Session session = sessionFactory.getCurrentSession();
        Query<QFAQ> query = session.createQuery("from QFAQ", QFAQ.class);
        List<QFAQ> qfaqs = query.getResultList();
        return qfaqs;
    }

    @Override
    public void saveQFAQ(QFAQ qfaq) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(qfaq);
    }

    @Override
    public void updateQFAQ(QFAQ qfaq) {
        Session session = sessionFactory.getCurrentSession();
        session.update(qfaq);
    }

    @Override
    public QFAQ getQFAQ(int qfaqid) {
        Session session = sessionFactory.getCurrentSession();
        QFAQ qfaq = session.get(QFAQ.class, qfaqid);
        return qfaq;
    }

    @Override
    public void deleteQFAQ(int qfaqid) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from QFAQ where id=:qfaqid");
        query.setParameter("qfaqid", qfaqid);
        query.executeUpdate();
    }

    @Override
    public List<QFAQ> getQFAQByTopicId(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<QFAQ> query = session.createQuery("FROM QFAQ q WHERE q.topic.topic_id =: topicid", QFAQ.class);
        query.setParameter("topicid", id);
        return query.getResultList();
    }

    @Override
    public List<QFAQ> getQFAQDoesNotHaveTopic(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<QFAQ> query = session.createQuery("select t.qfaqs from Topic t where t.id=:id");
        query.setParameter("id", id);
        List<QFAQ> qfaqList1 = query.getResultList();
        query = session.createQuery("from QFAQ ");
        List<QFAQ> qfaqList2 = query.getResultList();
        qfaqList2.removeAll(qfaqList1);
        return qfaqList2;
    }

    @Override
    public List<QFAQ> getQFAQDoesNotHaveAFAQ(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<QFAQ> Aquery = session.createQuery("select a.qfaqs from AFAQ a where a.id=:id");
        Aquery.setParameter("id", id);
        List<QFAQ> qfaqList1 = Aquery.getResultList();
        Aquery = session.createQuery("from QFAQ ");
        List<QFAQ> qfaqList2 = Aquery.getResultList();
        qfaqList2.removeAll(qfaqList1);
        return qfaqList2;
    }

    @Override
    public List<QFAQ> getQFAQByWords(String words) {
        Session session = sessionFactory.getCurrentSession();
        Query<QFAQ> query = session.createQuery("FROM QFAQ q WHERE q.qfaq_name LIKE :qqt", QFAQ.class);
        query.setParameter("qqt", "%"+words+"%");
        return query.getResultList();
    }

    @Override
    public int saveqfaqint(QFAQ qfaq) {
        Session session = sessionFactory.getCurrentSession();
        return (int)session.save(qfaq);
    }

    @Override
    public List<QFAQ> CheckWords(String words) {
        Session session = sessionFactory.getCurrentSession();
        Query<QFAQ> query = session.createQuery("FROM QFAQ q WHERE q.qfaq_name = :qqt", QFAQ.class);
        query.setParameter("qqt", words);
        return query.getResultList();
    }

}
