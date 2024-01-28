package org.itsci.projectweb.service;

import org.itsci.projectweb.dao.AFAQDao;
import org.itsci.projectweb.dao.QFAQDao;
import org.itsci.projectweb.model.AFAQ;
import org.itsci.projectweb.model.QFAQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class AFAQServiceImpl implements AFAQService {

    @Autowired
    private AFAQDao afaqDao;

    @Autowired
    private QFAQDao qfaqDao;

    @Override
    @Transactional
    public void saveAFAQ(Map<String, String> map) {
        int qfaq_id = Integer.parseInt(map.get("qfaq_id"));
        QFAQ qfaq = qfaqDao.getQFAQById(qfaq_id);
        String afaq_name = map.get("afaqtext");
        AFAQ afaq = new AFAQ(0,qfaq,afaq_name);
        qfaq.getAfaqs().add(afaq);
        afaqDao.saveAFAQ(afaq);
    }

    @Override
    @Transactional
    public AFAQ getAFAQById(String afaqId) {
        return afaqDao.getAFAQById(Integer.parseInt(afaqId));
    }

    @Override
    @Transactional
    public void updateAFAQ(Map<String, String> map) {
        AFAQ afaq = afaqDao.getAFAQById(Integer.parseInt(map.get("afaq_id")));
        afaq.setAfaq_name(map.get("afaqtext"));
        afaqDao.updateAFAQ(afaq);
    }

    @Override
    @Transactional
    public void deleteAFAQ(String afaqId) {
        AFAQ afaq = afaqDao.getAFAQById(Integer.parseInt(afaqId));
        QFAQ qfaq = qfaqDao.getQFAQById(afaq.getQfaq().getQfaq_id());
        qfaq.getAfaqs().remove(afaq);
        qfaqDao.updateQFAQ(qfaq);
        afaq.setQfaq(null);
        afaqDao.updateAFAQ(afaq);
        afaqDao.deleteAFAQ(afaq);
    }

    @Override
    @Transactional
    public List<AFAQ> getAFAQsByCheckWords(String words) {
        return afaqDao.CheckWords(words);
    }
}
