package org.itsci.projectweb.service;

import org.itsci.projectweb.model.Category;
import org.itsci.projectweb.model.Topic;

import javax.validation.Valid;
import java.util.List;
public interface TopicService {
    List<Topic> getTopics();
    void saveTopic(Topic topic);
    Topic getTopic(int topicId);
    void deleteTopic(int topicId);
//    void deleteQFAQ(int QFAQId);
    void updateTopic(Topic topic);

    void addQFAQToTopic(int topicId, int qfaqId);

    void removeQFAQFromTopic(int topicId, int qfaqId);

    List<Topic> getTopicDoesNotHaveQFAQ(int id);

    List<Topic> getTopicByCategory(String category);

    List<Category> getCategory();

    Category getCategoryById(String cgId);

    List<Topic> getTopicsByWords(String words);
}
