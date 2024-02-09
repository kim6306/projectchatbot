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
    public Topic getTopicById(int topicId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Topic> query = session.createQuery("FROM Topic t WHERE t.topic_id =: tId", Topic.class);
        query.setParameter("tId", topicId);
        return query.getSingleResult();
    }

    @Override
    public List<Topic> CheckWords(String words) {
        Session session = sessionFactory.getCurrentSession();
        Query<Topic> query = session.createQuery("FROM Topic t WHERE t.topic_name = :tpN", Topic.class );
        query.setParameter("tpN", words);
        return query.getResultList();
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

    @Override
    public List<Topic> getTopicsByCategoryName(String category_name) {
        Session session = sessionFactory.getCurrentSession();
        Query<Topic> query = session.createQuery("FROM Topic t WHERE t.category_name = :tpN", Topic.class );
        query.setParameter("tpN", category_name);
        return query.getResultList();
    }



}
