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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TopicServiceImpl implements TopicService{

    @Autowired
    private TopicDao topicDao;

    @Autowired
    private QFAQDao qfaqDao;

    @Autowired
    private AFAQDao afaqDao;



    @Override
    @Transactional
    public List<Topic> getAllTopics() {
        return topicDao.getAllTopics();
    }


    @Override
    @Transactional
    public Topic getTopicById(int topicId) {
        return topicDao.getTopicById(topicId);
    }

    @Override
    @Transactional
    public void updateTopic(Map<String, String> map) {
        Topic topic = topicDao.getTopicById(Integer.parseInt(map.get("topic_id")));
        topic.setTopic_name(map.get("topictext"));
        topic.setCategory_name(map.get("category_name"));
        topicDao.updateTopic(topic);
    }

    @Override
    @Transactional
    public void deleteTopic(int topicId) {
        Topic topic = topicDao.getTopicById(topicId);
        for (QFAQ qfaq : topic.getQfaqs()) {
            for (AFAQ afaq : qfaq.getAfaqs()) {
                afaq.setQfaq(null);
                afaqDao.updateAFAQ(afaq);
                afaqDao.deleteAFAQ(afaq);
            }
            qfaq.setAfaqs(null);
            qfaq.setTopic(null);
            qfaqDao.updateQFAQ(qfaq);
            qfaqDao.deleteQFAQ(qfaq);
        }
        topic.setQfaqs(null);
        topicDao.updateTopic(topic);
        topicDao.deleteTopic(topic);
    }

    @Override
    @Transactional
    public void saveTopic(Map<String, String> map) {
        String topic_name = map.get("topictext");
        String category_name = map.get("category_name");
        List<QFAQ> qfaqs = new ArrayList<>();
        Topic topic = new Topic(0, topic_name, qfaqs, category_name);
        topicDao.saveTopic(topic);
    }

    @Override
    @Transactional
    public List<Topic> getTopicsByCheckWords(String words) {
        return topicDao.CheckWords(words);
    }

    @Override
    @Transactional
    public List<Topic> getTopicsByCategoryName(String category_name) {
        return topicDao.getTopicsByCategoryName(category_name);
    }

}
