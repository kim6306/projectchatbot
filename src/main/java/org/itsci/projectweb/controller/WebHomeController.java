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
    public String goToHomePage(Model model) {
        model.addAttribute("topics", topicService.getAllTopics());
        return "home";
    }

    @GetMapping("/searchQFAQ")
    public String searchFAQ (@RequestParam Map<String, String> map, Model model) {
        String qfaq_name = map.get("se");
        List<Topic> allTopics = topicService.getAllTopics();
        List<Integer> index = new ArrayList<>();
        for (Topic topic: allTopics) {
            for (int i = 0 ; i<topic.getQfaqs().size();i++){
                if (!topic.getQfaqs().get(i).getQfaq_name().contains(qfaq_name)){
                    index.add(topic.getQfaqs().get(i).getQfaq_id());
                }
            }
            System.out.println(topic.getQfaqs().size()+"size");
            for (Integer integer:index){
               for (int j = 0 ; j<topic.getQfaqs().size();j++){
                   if (topic.getQfaqs().get(j).getQfaq_id()==integer){
                       topic.getQfaqs().remove(j);
                   }
               }
            }
            index.clear();
        }
        for (int k = 0 ; k<allTopics.size();k++){
            if (allTopics.get(k).getQfaqs().size()==0){
                allTopics.remove(k);
            }
        }
        model.addAttribute("topics", allTopics);
//        System.out.println(topics.size());
        return "home";
    }

    @GetMapping("/update-page")
    public String update(Model model) {
        model.addAttribute("topics", topicService.getAllTopics());
        return "update-page";
    }

    @RequestMapping("/apply-to-study-page")
    public String goToApplyToStudyPage (Model model) {
        model.addAttribute("topics", topicService.getTopicsByCategoryName("การสมัครเรียน"));
        return "Apply-to-study";
    }

    @RequestMapping("/activity-page")
    public String goToActivityPage (Model model) {
        model.addAttribute("topics", topicService.getTopicsByCategoryName("กิจกรรม"));
        return "Activity";
    }

}

