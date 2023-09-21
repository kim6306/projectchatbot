package org.itsci.projectweb.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.itsci.projectweb.model.Topic;
import org.itsci.projectweb.model.QFAQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TopicDaoImpl implements TopicDao  {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Topic> getTopic() {
        Session session = sessionFactory.getCurrentSession();
        Query<Topic> query = session.createQuery("FROM Topic", Topic.class);
        List<Topic> topics = query.getResultList();
        return topics;
    }

    @Override
    public void saveTopic(Topic topic) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(topic);
    }

    @Override
    public Topic getTopic(int topicid) {
        Session session = sessionFactory.getCurrentSession();
        Topic topic = session.get(Topic.class, topicid);
        return topic;
    }

    @Override
    public void deleteTopic(int topicid) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Topic where id=:topicid");
        query.setParameter("topicid", topicid);
        query.executeUpdate();
    }
    @Override
    public void deleteQAFQ(int qfaqid) {
        Session session = sessionFactory.getCurrentSession();
        Query<Topic> query = session.createQuery("delete from QFAQ q where q.id=:qfaqid");
        query.setParameter("qfaqid", qfaqid);
        query.executeUpdate();
    }

    @Override
    public List<Topic> getTopicDoesNotHaveQFAQ(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Topic> query = session.createQuery("select q.topics from QFAQ q where q.id=:id");
        query.setParameter("id", id);
        List<Topic> topicList1 = query.getResultList();
        query = session.createQuery("from Topic ");
        List<Topic> topicList2 = query.getResultList();
        topicList2.removeAll(topicList1);
        return topicList2;
    }

    @Override
    public List<Topic> getTopicByCategory(String category) {
        Session session = sessionFactory.getCurrentSession();
        Query<Topic> query = session.createQuery("from Topic t where t.category.catetext=:category");
        query.setParameter("category",category);
        return query.getResultList();
    }

}
