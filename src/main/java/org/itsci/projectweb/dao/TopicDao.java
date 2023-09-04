package org.itsci.projectweb.dao;

import org.itsci.projectweb.model.Topic;
import java.util.List;
public interface TopicDao {
    List<Topic> getTopic();
    void saveTopic(Topic topic);
    Topic getTopic(int id);
    void deleteTopic(int id);
    void deleteQAFQ(int id);
    List<Topic> getTopicDoesNotHaveQFAQ(int id);
}
