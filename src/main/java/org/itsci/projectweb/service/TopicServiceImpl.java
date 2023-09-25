package org.itsci.projectweb.service;

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
    private TopicDao topicDao;

    @Autowired
    private QFAQDao qfaqDao;
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


}
