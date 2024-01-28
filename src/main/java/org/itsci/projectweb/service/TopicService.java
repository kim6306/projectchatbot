package org.itsci.projectweb.service;

import org.itsci.projectweb.model.Category;
import org.itsci.projectweb.model.Topic;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

public interface TopicService {

    List<Topic> getAllTopics ();
    List<Topic> getTopicsByCategoryId (String categoryId);
    Topic getTopicById (int topicId);
    void updateTopic (Map<String, String> map);
    void deleteTopic (int topicId);
    void saveTopic (Map<String, String> map);
    List<Topic> getTopicsByCheckWords(String words);
    List<Category> getCategory();

}
