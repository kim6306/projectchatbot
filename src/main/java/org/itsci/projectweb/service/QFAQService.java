package org.itsci.projectweb.service;

import org.itsci.projectweb.model.QFAQ;
import org.itsci.projectweb.model.Topic;

import java.util.List;
import java.util.Map;

public interface QFAQService {

    void saveQFAQ (Map<String, String> map);
    void deleteQFAQ (int qfaqId);

    QFAQ getQFAQById (int qfaqId);
    void updateQFAQ (Map<String, String> map);

}
