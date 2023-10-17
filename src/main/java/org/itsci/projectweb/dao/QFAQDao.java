package org.itsci.projectweb.dao;

import org.itsci.projectweb.model.AFAQ;
import org.itsci.projectweb.model.QFAQ;
import org.itsci.projectweb.model.Topic;

import java.util.List;
public interface QFAQDao {
    List<QFAQ> getQFAQs();
    void saveQFAQ(QFAQ qfaq);
    QFAQ getQFAQ(int id);
    void deleteQFAQ(int id);
    List<QFAQ> getQFAQByTopicId (int id);
    List<QFAQ> getQFAQDoesNotHaveTopic(int id);

    List<QFAQ> getQFAQDoesNotHaveAFAQ(int id);
    List<QFAQ> getQFAQByWords(String words);
}
