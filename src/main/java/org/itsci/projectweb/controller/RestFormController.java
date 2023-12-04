package org.itsci.projectweb.controller;

import org.itsci.projectweb.model.Topic;
import org.itsci.projectweb.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class RestFormController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/test/{topicName}")
    public ResponseEntity testRest (@PathVariable("topicName") String topicName) {
        try {
            List<Topic> topics = topicService.getTopics();
            Topic topic = topicService.getTopicByTopicName(topicName);
            int index = 0;
            for (int i = 0; i < topics.size(); i++) {
                if (topics.get(i).getTopic_name().equals(topic.getTopic_name())) {
                    index = i + 1;
                    break;
                }
            }
            System.out.println(topicName + " : TOPIC NAME");
            return new ResponseEntity<>(index + "." + (topic.getQfaqs().size()+1), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
