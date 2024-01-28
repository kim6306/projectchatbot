package org.itsci.projectweb.dao;

import org.itsci.projectweb.model.AFAQ;
import org.itsci.projectweb.model.QFAQ;
import org.itsci.projectweb.model.Topic;

import java.util.List;
public interface QFAQDao {

    void saveQFAQ (QFAQ qfaq);
    void deleteQFAQ (QFAQ qfaq);
    QFAQ getQFAQById (int qfaqId);
    void updateQFAQ (QFAQ qfaq);
    List<QFAQ> getQFAQByQFAQName (String qfaq_name);
    List<QFAQ> CheckWords(String words);

}
