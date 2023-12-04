package org.itsci.projectweb.service;

import org.itsci.projectweb.model.AFAQ;
import org.itsci.projectweb.model.QFAQ;

import java.util.List;

public interface AFAQService {
    List<AFAQ> getAFAQ();
    public void saveAFAQ(AFAQ afaq);
    AFAQ getAFAQ(int afaqId);
    void deleteAFAQ(int afaqId);
    void updateAFAQ(AFAQ afaqEntity, AFAQ afaq);

    List<AFAQ> getAFAQDoesNotHaveQFAQ(int id);

    void saveafaqwithqfaq(String afaqtext,int qfaqid);
    List<AFAQ> getAFAQsByCheckWords(String words);
    void updateAFAQ2( AFAQ afaq);
}
