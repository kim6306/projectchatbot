package org.itsci.projectweb.dao;

import org.itsci.projectweb.model.Topic;
import java.util.List;
public interface TopicDao {

    List<Topic> getAllTopics ();

    Topic getTopicById (int topicId);

    List<Topic> CheckWords (String words);

    void updateTopic (Topic topic);
    void deleteTopic (Topic topic);
    void saveTopic (Topic topic);
    List<Topic> getTopicsByCategoryName (String category_name);

}
