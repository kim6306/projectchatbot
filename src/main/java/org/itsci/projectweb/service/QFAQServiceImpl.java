package org.itsci.projectweb.service;

import org.itsci.projectweb.dao.AFAQDao;
import org.itsci.projectweb.dao.QFAQDao;
import org.itsci.projectweb.model.AFAQ;
import org.itsci.projectweb.model.QFAQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QFAQServiceImpl implements QFAQService {

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
                System.out.println(afaq.getId());
                afaqDao.deleteAFAQ(afaq.getId());
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

}
