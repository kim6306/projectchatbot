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
public class AFAQServiceImpl implements AFAQService {

    @Autowired
    private AFAQDao afaqDao;

    @Autowired
    private QFAQDao qfaqDao;

    @Override
    @Transactional
    public List<AFAQ> getAFAQ() {
        return afaqDao.getAFAQs();
    }

    @Override
    @Transactional
    public void saveAFAQ(AFAQ afaq) {
        afaqDao.saveAFAQ(afaq);
    }

    @Override
    @Transactional
    public AFAQ getAFAQ(int afaqId) {
        return afaqDao.getAFAQ(afaqId);
    }

    @Override
    @Transactional
    public void deleteAFAQ(int afaqId) {
        afaqDao.deleteAFAQ(afaqId);
    }

    @Override
    @Transactional
    public void updateAFAQ(AFAQ afaqEntity, AFAQ afaq) {
        afaqEntity.fill(afaq);
        afaqDao.saveAFAQ(afaqEntity);
    }

    @Override
    @Transactional
    public List<AFAQ> getAFAQDoesNotHaveQFAQ(int id) {
        return afaqDao.getAFAQDoesNotHaveQFAQ(id);
    }

    @Override
    @Transactional
    public void saveafaqwithqfaq(String afaqtext, int qfaqid) {
        QFAQ qfaq = qfaqDao.getQFAQ(qfaqid);
        AFAQ afaq = new AFAQ();
        int newafaqid = 0;
        afaq.setAfaq_name(afaqtext);
        afaq.setQfaqs((List<QFAQ>) qfaq);
        newafaqid = afaqDao.saveafaqint(afaq);
        AFAQ newafaq = afaqDao.getAFAQ(newafaqid);
        afaqDao.saveAFAQ(newafaq);
        qfaq.getAfaqs().add(newafaq);
        qfaqDao.saveQFAQ(qfaq);
    }

    @Override
    @Transactional
    public List<AFAQ> getAFAQsByCheckWords(String words) {
        return afaqDao.CheckWords(words);
    }

    @Override
    public void updateAFAQ2(AFAQ afaq) {
        afaqDao.updateAFAQ(afaq);
    }

}
