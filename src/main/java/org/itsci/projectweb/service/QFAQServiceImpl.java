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

import java.util.List;

@Service
public class QFAQServiceImpl implements QFAQService {

    @Autowired
    private TopicDao topicDao;
    @Autowired
    private AFAQDao afaqDao;

    @Autowired
    private QFAQDao qfaqDao;

    @Override
    @Transactional
    public List<QFAQ> getQFAQ() {
        return qfaqDao.getQFAQs();
    }

    @Override
    @Transactional
    public void saveQFAQ(QFAQ qfaq) {
        qfaqDao.saveQFAQ(qfaq);
    }



    @Override
    @Transactional
    public QFAQ getQFAQ(int qfaqId) {
        return qfaqDao.getQFAQ(qfaqId);
    }

    @Override
    @Transactional
    public void deleteQFAQ(int qfaqId) {
        QFAQ qfaq = qfaqDao.getQFAQ(qfaqId);
        for(AFAQ afaq:qfaq.getAfaqs()){
            if (afaq.getQfaqs().size()<=1){
                afaqDao.deleteAFAQ(afaq.getAfaq_id());
            }
        }
        qfaqDao.deleteQFAQ(qfaqId);
    }

    @Override
    @Transactional
    public void updateQFAQ(QFAQ qfaqEntity, QFAQ qfaq) {
        qfaqEntity.fill(qfaq);
        qfaqDao.saveQFAQ(qfaqEntity);
    }

    @Override
    @Transactional
    public void addQFAQToAFAQ(int qfaqId, int afaqId) {
        QFAQ qfaq = qfaqDao.getQFAQ(qfaqId);
        AFAQ afaq = afaqDao.getAFAQ(afaqId);
        qfaq.getAfaqs().add(afaq);
        qfaqDao.saveQFAQ(qfaq);
    }

    @Override
    @Transactional
    public void removeQFAQFromAFAQ(int qfaqId, int afaqId) {
        QFAQ qfaq = qfaqDao.getQFAQ(qfaqId);
        AFAQ afaq = afaqDao.getAFAQ(afaqId);
        qfaq.getAfaqs().remove(afaq);
        qfaqDao.saveQFAQ(qfaq);
    }

    @Override
    public List<QFAQ> getQFAQByTopicId(int id) {
        return null;
    }

    @Override
    @Transactional
    public List<QFAQ> getQFAQDoesNotHaveTopic(int id) {
        return qfaqDao.getQFAQDoesNotHaveTopic(id);
    }

    @Override
    @Transactional
    public List<QFAQ> getQFAQDoesNotHaveAFAQ(int id) {
        return qfaqDao.getQFAQDoesNotHaveAFAQ(id);
    }

    @Override
    @Transactional
    public List<QFAQ> getQFAQByWords(String words) {
        return qfaqDao.getQFAQByWords(words);
    }

    @Override
    @Transactional
    public void saveqfaqwithafaq(String qfaqtext, String afaqtext, int topicid) {
        Topic topic = topicDao.getTopic(topicid);
        QFAQ qfaq = new QFAQ();
        int newqfaqid = 0;
        AFAQ afaq = new AFAQ();
        qfaq.setQfaq_name(qfaqtext);
        qfaq.setTopic(topic);
        afaq.setAfaq_name(afaqtext);
        newqfaqid = qfaqDao.saveqfaqint(qfaq);
        QFAQ newqfaq = qfaqDao.getQFAQ(newqfaqid);
        afaq.getQfaqs().add(newqfaq);
        int newafaqid = 0;
        newafaqid = afaqDao.saveafaqint(afaq);
        AFAQ newafaq = afaqDao.getAFAQ(newafaqid);
        newqfaq.getAfaqs().add(newafaq);
        qfaqDao.saveQFAQ(newqfaq);
        topic.getQfaqs().add(newqfaq);
        topicDao.saveTopic(topic);
    }

    @Override
    @Transactional
    public List<QFAQ> getQFAQsByCheckWords(String words) {
        return qfaqDao.CheckWords(words);
    }

}
