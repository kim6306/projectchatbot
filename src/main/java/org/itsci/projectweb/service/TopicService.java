package org.itsci.projectweb.service;

import org.itsci.projectweb.model.Topic;
import java.util.List;
public interface TopicService {
    List<Topic> getTopics();
    void saveTopic(Topic topic);
    Topic getTopic(int topicId);
    void deleteTopic(int topicId);
    void deleteQFAQ(int qfaqId);
    void updateTopic(Topic topicEntity, Topic topic);

    void addQFAQToTopic(int topicId, int qfaqId);

    void removeQFAQFromTopic(int topicId, int qfaqId);

    List<Topic> getTopicDoesNotHaveQFAQ(int id);
}
