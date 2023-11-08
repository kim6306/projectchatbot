package org.itsci.projectweb.controller;
import org.itsci.projectweb.model.QFAQ;
import org.itsci.projectweb.model.Topic;
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
    private QFAQService qfaqService;

    @RequestMapping("/")
    public String showHome(Model model) {
        model.addAttribute("topics", topicService.getTopics());
        System.out.println(topicService.getTopics().get(0).getTopic_name());
        System.out.println(topicService.getTopics().get(0).getQfaqs().size());
        return "home";
    }
    @GetMapping("/update")
    public String update(Model model) {
        model.addAttribute("topics", topicService.getTopics());
        System.out.println(topicService.getTopics().get(0).getTopic_name());
        System.out.println(topicService.getTopics().get(0).getQfaqs().size());
        return "update-page";
    }

    @GetMapping("/AtS")
    public String AtS(Model model) {
        model.addAttribute("topics", topicService.getTopicByCategory("การเข้าสมัครเรียน"));
        System.out.println(topicService.getTopics().get(0).getTopic_name());
        System.out.println(topicService.getTopics().get(0).getQfaqs().size());
        return "Apply-to-study";
    }

    @GetMapping("/Act")
    public String Activity(Model model) {
        model.addAttribute("topics", topicService.getTopicByCategory("กิจกรรมและหลักสูตร"));
        System.out.println(topicService.getTopics().get(0).getTopic_name());
        System.out.println(topicService.getTopics().get(0).getQfaqs().size());
        return "Activity";
    }
    @RequestMapping("/searchFAQ")
    public String searchByWords(@RequestParam Map<String, String> map, Model model){
        String words = map.get("se");
        List<Topic> topics = new ArrayList<>();
        List<QFAQ> qfaqs = new ArrayList<>();
        if (words == null|| words.length() <= 0){
            topics = topicService.getTopics();
            qfaqs = qfaqService.getQFAQ();
        }
        else {
            qfaqs = qfaqService.getQFAQByWords(words);
//            System.out.println("sizeQAFQ"+qfaqs.size());
            for (QFAQ qfaq:qfaqs){
                topics.add(qfaq.getTopic());
            }
//            System.out.println("Topicsize"+topics.size());
        }
        model.addAttribute("qfaqs",qfaqs);
        model.addAttribute("topics",topics);
        return "home";
    }
}

