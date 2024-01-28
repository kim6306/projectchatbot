package org.itsci.projectweb.controller;
import org.itsci.projectweb.model.QFAQ;
import org.itsci.projectweb.model.Topic;
import org.itsci.projectweb.service.CategoryService;
import org.itsci.projectweb.service.QFAQService;
import org.itsci.projectweb.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class WebHomeController {

    @Autowired
    private TopicService topicService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private QFAQService qfaqService;

    @RequestMapping("/")
    public String goToHomePage(Model model) {
        model.addAttribute("topics", topicService.getAllTopics());
        return "home";
    }

    @GetMapping("/searchQFAQ")
    public String searchFAQ (@RequestParam Map<String, String> map, Model model) {
        String qfaq_name = map.get("se");
        List<QFAQ> qfaqs = qfaqService.getQFAQByQFAQName(qfaq_name);
        List<Topic> topics = new ArrayList<>();
        for (QFAQ qfaq : qfaqs) {
            if (topics.size() == 0) {
                topics.add(qfaq.getTopic());
            } else {
                for (Topic topic : topics) {
                    if (topic.getTopic_id() != qfaq.getTopic().getTopic_id()) {
                        topics.add(qfaq.getTopic());
                    }
                }
            }
        }
        model.addAttribute("topics", topics);
        System.out.println(topics.size());
        return "home";
    }

    @GetMapping("/update-page")
    public String update(Model model) {
        model.addAttribute("topics", topicService.getAllTopics());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "update-page";
    }

    @RequestMapping("/apply-to-study-page")
    public String goToApplyToStudyPage (Model model) {
        model.addAttribute("topics", topicService.getTopicsByCategoryId("2"));
        return "home";
    }

    @RequestMapping("/activity-page")
    public String goToActivityPage (Model model) {
        model.addAttribute("topics", topicService.getTopicsByCategoryId("4"));
        return "home";
    }

}

