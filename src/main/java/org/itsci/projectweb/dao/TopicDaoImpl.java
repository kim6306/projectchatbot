package org.itsci.projectweb.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.itsci.projectweb.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TopicDaoImpl implements TopicDao  {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Topic> getAllTopics() {
        Session session = sessionFactory.getCurrentSession();
        Query<Topic> query = session.createQuery("FROM Topic", Topic.class);
        return query.getResultList();
    }

    @Override
    public List<Topic> getTopicsByCategoryId(String categoryId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Topic> query = session.createQuery("FROM Topic t WHERE t.category.category_id =: cId", Topic.class);
        query.setParameter("cId", categoryId);
        return query.getResultList();
    }

    @Override
    public Topic getTopicById(int topicId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Topic> query = session.createQuery("FROM Topic t WHERE t.topic_id =: tId", Topic.class);
        query.setParameter("tId", topicId);
        return query.getSingleResult();
    }

    @Override
    public void updateTopic(Topic topic) {
        Session session = sessionFactory.getCurrentSession();
        session.update(topic);
    }

    @Override
    public void deleteTopic(Topic topic) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(topic);
    }

    @Override
    public void saveTopic(Topic topic) {
        Session session = sessionFactory.getCurrentSession();
        session.save(topic);
    }


}
