package org.itsci.projectweb.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.itsci.projectweb.dao.*;
import org.itsci.projectweb.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;
@Service
public class TopicServiceImpl implements TopicService{

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private TopicDao topicDao;

    @Autowired
    private QFAQDao qfaqDao;

    @Autowired
    private AFAQDao afaqDao;

    @Autowired
    private QFAQService qfaqService;
    @Override
    @Transactional
    public List<Topic> getTopics() {
        return topicDao.getTopic();
    }

    @Override
    @Transactional
    public void saveTopic(Topic topic) {
        topicDao.saveTopic(topic);
    }

    @Override
    @Transactional
    public void updateTopic(Topic topic ) {
        topicDao.updateTopic(topic);
    }

    @Override
    @Transactional
    public Topic getTopic(int topicId) {
        return topicDao.getTopic(topicId);
    }

    @Override
    @Transactional
    public void deleteTopic(int topicId) {
        Topic topic = topicDao.getTopic(topicId);
        for(QFAQ qfaq:topic.getQfaqs()){
            for(AFAQ afaq:qfaq.getAfaqs()){
                if (afaq.getQfaqs().size()<=1){
                    System.out.println(afaq.getAfaq_id());
                    afaqDao.deleteAFAQ(afaq.getAfaq_id());
                }
            }
            qfaqDao.deleteQFAQ(qfaq.getQfaq_id());
        }
        topicDao.deleteTopic(topicId);
    }



    @Override
    @Transactional
    public void addQFAQToTopic(int topicId, int qfaqId) {
        QFAQ qfaq = qfaqDao.getQFAQ(qfaqId);
        Topic topic = topicDao.getTopic(topicId);
        topic.getQfaqs().add(qfaq);
        topicDao.saveTopic(topic);
    }

    @Override
    @Transactional
    public void removeQFAQFromTopic(int topicId, int qfaqId) {
        QFAQ qfaq = qfaqDao.getQFAQ(qfaqId);
        Topic topic = topicDao.getTopic(topicId);
        topic.getQfaqs().remove(qfaq);
        topicDao.saveTopic(topic);
    }

    @Override
    @Transactional
    public List<Topic> getTopicDoesNotHaveQFAQ(int id) {
        return topicDao.getTopicDoesNotHaveQFAQ(id);
    }

    @Override
    @Transactional
    public List<Topic> getTopicByCategory(String category) {
        return topicDao.getTopicByCategory(category);
    }

    @Override
    @Transactional
    public List<Category> getCategory() {
        return topicDao.getCategory();
    }

    @Override
    @Transactional
    public Category getCategoryById(String cgId) {
        return topicDao.getCategoryById(cgId);
    }

    @Override
    @Transactional
    public List<Topic> getTopicsByWords(String words) {
        return topicDao.getTopicsByWords(words);
    }

    @Override
    @Transactional
    public List<Topic> getTopicsByCheckWords(String words) {
        return topicDao.CheckWords(words);
    }


}
