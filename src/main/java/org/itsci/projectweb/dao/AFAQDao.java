package org.itsci.projectweb.dao;

import org.itsci.projectweb.model.AFAQ;
import org.itsci.projectweb.model.QFAQ;

import java.util.List;

public interface AFAQDao {

    void deleteAFAQ (AFAQ afaq);
    void updateAFAQ (AFAQ afaq);
    void saveAFAQ (AFAQ afaq);
    AFAQ getAFAQById (int afaqId);

}
