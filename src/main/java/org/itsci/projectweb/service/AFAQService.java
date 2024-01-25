package org.itsci.projectweb.service;

import org.itsci.projectweb.model.AFAQ;
import org.itsci.projectweb.model.QFAQ;

import java.util.List;
import java.util.Map;

public interface AFAQService {

    void saveAFAQ (Map<String, String> map);
    AFAQ getAFAQById (String afaqId);
    void updateAFAQ (Map<String, String> map);
    void deleteAFAQ (String afaqId);

}
