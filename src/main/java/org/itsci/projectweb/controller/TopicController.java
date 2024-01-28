package org.itsci.projectweb.controller;

import org.itsci.projectweb.model.*;
import org.itsci.projectweb.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/delete/{topicId}")
    public String deleteTopic (@PathVariable("topicId") String topicId) {
        topicService.deleteTopic(Integer.parseInt(topicId));
        return "redirect:/update-page";
    }

    @RequestMapping("/add-topic-page")
    public String goToAddTopicPage (Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "topic/topic-form";
    }

    @RequestMapping("/add-topic-page/{categoryId}")
    public String goToAddTopicPageWithCategoryId (Model model, @PathVariable("categoryId") String categoryId) {
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("categoryId", categoryId);
        return "topic/topic-form";
    }


    @RequestMapping("/list-page")
    public String goToTopicListPage (Model model) {
        model.addAttribute("topics", topicService.getAllTopics());
        return "topic/list";
    }

    @PostMapping("/save")
    public String saveTopic (@RequestParam Map<String, String> map, Model model) {
        String topic_name = map.get("topictext") ;
        if (topicService.getTopicsByCheckWords(topic_name).size()<=0){
            topicService.saveTopic(map);
        }else{
            model.addAttribute("ShowAlert",true);
            model.addAttribute("categories",topicService.getCategory());
            return "topic/topic-form";
        }
//        topicService.saveTopic(map);
        return "redirect:/update-page";
    }

    @RequestMapping("/update/{topicId}")
    public String goToUpdateTopicPage (@PathVariable("topicId") String topicId, Model model) {
        Topic topic = topicService.getTopicById(Integer.parseInt(topicId));
        model.addAttribute("topic", topic);
        model.addAttribute("categories", categoryService.getAllCategories());
        System.out.println("TOP NAME : " + topic.getTopic_name());
        return "topic/topic-form-update";
    }

    @PostMapping("/update")
    public String updateTopic (@RequestParam Map<String, String> map) {
        topicService.updateTopic(map);
        return "redirect:/update-page";
    }

}
