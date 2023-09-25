package org.itsci.projectweb.dao;

import org.itsci.projectweb.model.Category;
import org.itsci.projectweb.model.Topic;
import java.util.List;
public interface TopicDao {
    List<Topic> getTopic();
    void saveTopic(Topic topic);
    Topic getTopic(int id);
    void deleteTopic(int id);
    List<Topic> getTopicDoesNotHaveQFAQ(int id);
    List<Topic> getTopicByCategory(String category);
    List<Category> getCategory();
    Category getCategoryById(String cgId);
    public void updateTopic(Topic topic);
}
