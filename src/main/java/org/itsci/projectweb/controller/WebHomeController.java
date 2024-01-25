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

    @RequestMapping("/")
    public String goToHomePage(Model model) {
        model.addAttribute("topics", topicService.getAllTopics());
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
        model.addAttribute("topics", topicService.getTopicsByCategoryId("1"));
        return "Apply-to-study";
    }

    @RequestMapping("/activity-page")
    public String goToActivityPage (Model model) {
        model.addAttribute("topics", topicService.getTopicsByCategoryId("2"));
        return "Activity";
    }

}

