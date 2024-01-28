package org.itsci.projectweb.service;

import org.itsci.projectweb.dao.AFAQDao;
import org.itsci.projectweb.dao.QFAQDao;
import org.itsci.projectweb.dao.TopicDao;
import org.itsci.projectweb.model.AFAQ;
import org.itsci.projectweb.model.QFAQ;
import org.itsci.projectweb.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class QFAQServiceImpl implements QFAQService {

    @Autowired
    private QFAQDao qfaqDao;

    @Autowired
    private AFAQDao afaqDao;

    @Autowired
    private TopicDao topicDao;

    @Override
    @Transactional
    public void saveQFAQ(Map<String, String> map) {
        int topicId = Integer.parseInt(map.get("topic_id"));
        Topic topic = topicDao.getTopicById(topicId);
        String qfaq_name = map.get("qfaqtext");
        List<AFAQ> afaqs = new ArrayList<>();
        AFAQ afaq = new AFAQ();
        afaq.setAfaq_name(map.get("afaqtext"));
        afaqs.add(afaq);
        QFAQ qfaq = new QFAQ(0,qfaq_name,topic,afaqs);
        afaq.setQfaq(qfaq);
        qfaqDao.saveQFAQ(qfaq);
    }

    @Override
    @Transactional
    public void deleteQFAQ(int qfaqId) {
        QFAQ qfaq = qfaqDao.getQFAQById(qfaqId);
        for (AFAQ afaq : qfaq.getAfaqs()) {
            afaq.setQfaq(null);
            afaqDao.updateAFAQ(afaq);
            afaqDao.deleteAFAQ(afaq);
        }
        qfaq.setAfaqs(null);
        Topic topic = topicDao.getTopicById(qfaq.getTopic().getTopic_id());
        topic.getQfaqs().remove(qfaq);
        topicDao.updateTopic(topic);
        qfaq.setTopic(null);
        qfaqDao.updateQFAQ(qfaq);
        qfaqDao.deleteQFAQ(qfaq);
    }

    @Override
    @Transactional
    public QFAQ getQFAQById(int qfaqId) {
        return qfaqDao.getQFAQById(qfaqId);
    }

    @Override
    @Transactional
    public void updateQFAQ(Map<String, String> map) {
        QFAQ qfaq = qfaqDao.getQFAQById(Integer.parseInt(map.get("qfaq_id")));
        qfaq.setQfaq_name(map.get("qfaqtext"));
        if (qfaq.getTopic().getTopic_id() != Integer.parseInt(map.get("topic_id"))) {
            Topic topic = topicDao.getTopicById(Integer.parseInt(map.get("topic_id")));
            qfaq.setTopic(topic);
        }
        qfaqDao.updateQFAQ(qfaq);
    }

    @Override
    @Transactional
    public List<QFAQ> getQFAQByQFAQName(String qfaq_name) {
        return qfaqDao.getQFAQByQFAQName(qfaq_name);
    }
}
