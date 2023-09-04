package org.itsci.projectweb.service;

import org.itsci.projectweb.model.AFAQ;

import java.util.List;

public interface AFAQService {
    List<AFAQ> getAFAQ();
    public void saveAFAQ(AFAQ afaq);
    AFAQ getAFAQ(int afaqId);
    void deleteAFAQ(int afaqId);
    void updateAFAQ(AFAQ afaqEntity, AFAQ afaq);

    List<AFAQ> getAFAQDoesNotHaveQFAQ(int id);
}
