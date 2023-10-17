package org.itsci.projectweb.service;

import org.itsci.projectweb.model.QFAQ;
import org.itsci.projectweb.model.Topic;

import java.util.List;

public interface QFAQService {
    List<QFAQ> getQFAQ();
    public void saveQFAQ(QFAQ qfaq);
    QFAQ getQFAQ(int qfaqId);
    void deleteQFAQ(int qfaqId);
    void updateQFAQ(QFAQ qfaqEntity, QFAQ qfaq);

    void addQFAQToAFAQ(int qfaqId, int afaqId);

    void removeQFAQFromAFAQ(int qfaqId, int afaqId);

    List<QFAQ> getQFAQByTopicId (int id);
    List<QFAQ> getQFAQDoesNotHaveTopic(int id);
    List<QFAQ> getQFAQDoesNotHaveAFAQ(int id);

    List<QFAQ> getQFAQByWords(String words);
}
