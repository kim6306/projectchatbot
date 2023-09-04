package org.itsci.projectweb.dao;

import org.itsci.projectweb.model.AFAQ;
import org.itsci.projectweb.model.QFAQ;

import java.util.List;

public interface AFAQDao {
    List<AFAQ> getAFAQs();

    void saveAFAQ(AFAQ afaq);

    AFAQ getAFAQ(int id);

    void deleteAFAQ(int id);

    List<AFAQ> getAFAQDoesNotHaveQFAQ(int id);
}
