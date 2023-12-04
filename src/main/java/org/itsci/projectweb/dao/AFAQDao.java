package org.itsci.projectweb.dao;

import org.itsci.projectweb.model.AFAQ;
import org.itsci.projectweb.model.QFAQ;

import java.util.List;

public interface AFAQDao {
    List<AFAQ> getAFAQs();

    void saveAFAQ(AFAQ afaq);
    void updateAFAQ(AFAQ afaq);

    AFAQ getAFAQ(int id);

    void deleteAFAQ(int id);

    List<AFAQ> getAFAQDoesNotHaveQFAQ(int id);

    int saveafaqint (AFAQ afaq);
    List<AFAQ> CheckWords(String words);
}
