package org.itsci.projectweb.controller;
import org.itsci.projectweb.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebHomeController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/")
    public String showHome(Model model) {
        model.addAttribute("topics", topicService.getTopics());
        System.out.println(topicService.getTopics().get(0).getTopictext());
        System.out.println(topicService.getTopics().get(0).getQfaqs().size());
        return "home";
    }
    @GetMapping("/update")
    public String update(Model model) {
        model.addAttribute("topics", topicService.getTopics());
        System.out.println(topicService.getTopics().get(0).getTopictext());
        System.out.println(topicService.getTopics().get(0).getQfaqs().size());
        return "update-page";
    }

    @GetMapping("/AtS")
    public String AtS(Model model) {
        model.addAttribute("topics", topicService.getTopicByCategory("สมัครเรียน"));
        System.out.println(topicService.getTopics().get(0).getTopictext());
        System.out.println(topicService.getTopics().get(0).getQfaqs().size());
        return "Apply-to-study";
    }

    @GetMapping("/Act")
    public String Activity(Model model) {
        model.addAttribute("topics", topicService.getTopicByCategory("กิจกรรม"));
        System.out.println(topicService.getTopics().get(0).getTopictext());
        System.out.println(topicService.getTopics().get(0).getQfaqs().size());
        return "Activity";
    }
}
