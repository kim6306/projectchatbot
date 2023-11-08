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
    public void updateTopic(Topic topic) {
        Session session = sessionFactory.getCurrentSession();
        session.update(topic);
    }

    @Override
    public List<Topic> getTopicsByWords(String words) {
        Session session = sessionFactory.getCurrentSession();
        Query<Topic> query = session.createQuery("FROM Topic t WHERE t.topic_name LIKE :tpt", Topic.class);
        query.setParameter("tpt", "%"+words+"%");
        return query.getResultList();
    }

    @Override
    public List<Topic> CheckWords(String words) {
        Session session = sessionFactory.getCurrentSession();
        Query<Topic> query = session.createQuery("FROM Topic t WHERE t.topic_name = :tpt", Topic.class );
        query.setParameter("tpt", words);
        return query.getResultList();
    }

    @Override
    public void deleteTopic(int topicid) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Topic where id=:topicid");
        query.setParameter("topicid", topicid);
        query.executeUpdate();
    }

    @Override
    public void deleteTopicObject(Topic topic) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(topic);
    }

    @Override
    public List<Topic> getTopicDoesNotHaveQFAQ(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Topic> query = session.createQuery("select q.topic from QFAQ q where q.id=:id");
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
        Query<Topic> query = session.createQuery("from Topic t where t.category.category_name =:category");
        query.setParameter("category",category);
        return query.getResultList();
    }

    @Override
    public List<Category> getCategory() {
        Session session = sessionFactory.getCurrentSession();
        Query<Category> query = session.createQuery("from Category ",Category.class);
        List<Category> category = query.getResultList();
        return category ;
    }

    @Override
    public Category getCategoryById(String cgId) {
        Session session = sessionFactory.getCurrentSession();
        Category category =session.get(Category.class,cgId);
        return category;
    }



}
