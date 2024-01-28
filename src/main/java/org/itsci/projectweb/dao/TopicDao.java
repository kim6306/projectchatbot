package org.itsci.projectweb.dao;

import org.itsci.projectweb.model.Category;
import org.itsci.projectweb.model.QFAQ;
import org.itsci.projectweb.model.Topic;
import java.util.List;
public interface TopicDao {

    List<Topic> getAllTopics ();
    List<Topic> getTopicsByCategoryId (String categoryId);
    Topic getTopicById (int topicId);

    List<Topic> CheckWords (String words);
    List<Category> getCategory();
    void updateTopic (Topic topic);
    void deleteTopic (Topic topic);
    void saveTopic (Topic topic);

}
