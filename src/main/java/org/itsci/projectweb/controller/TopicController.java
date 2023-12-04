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
    private String title = "หัวข้อ";
    @Autowired
    private TopicService topicService;
    @Autowired
    private QFAQService qfaqService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public String listTopic(Model model) {
        model.addAttribute("topics", topicService.getTopics());
        return "topic/list";
    }
    @GetMapping("/create")
    public String showFormForAdd(Model model) {
        model.addAttribute("categorys",topicService.getCategory());
        return "topic/topic-form";
    }
    @GetMapping("/{id}/update")
    public String showFormForUpdate(@PathVariable("id") int id,Model model){
        Topic topic = topicService.getTopic(id);
        List<Category> category = topicService.getCategory();
        model.addAttribute("topic_detail", topic);
        model.addAttribute("category_detail", category);
        return "topic/topic-form-update";
    }
    @PostMapping(path = "/save")
    public String processForm(@RequestParam Map<String, String>  allReqParams,Model model ) throws ParseException {
            String topictext = allReqParams.get("topictext");
            Category category = topicService.getCategoryById(allReqParams.get("category_id"));
            if (topicService.getTopicsByCheckWords(topictext).size()<=0){
                Topic topic = new Topic(topictext,category);
                topicService.saveTopic(topic);
            }else{
                model.addAttribute("ShowAlert",true);
                model.addAttribute("categorys",topicService.getCategory());
                return "topic/topic-form";
            }
            return "redirect:/update";
    }
    @PostMapping(path = "/{t_id}/save")
    public String saveEditProfile(@RequestParam Map<String, String> allReqParams, @PathVariable int t_id,Model model) throws ParseException {
        Topic topic = topicService.getTopic(t_id);
        if (topic != null) {
            topic.setTopic_name(allReqParams.get("topictext"));
            System.out.println("TOPICCCC : " + allReqParams.get("topictext"));
            String categoryId = allReqParams.get("category_id");
            Category cate_gory = topicService.getCategoryById(categoryId);
            if (cate_gory != null) {
                System.out.println("FLAG 2");
                topic.setCategory(cate_gory);
                if (topicService.getTopicsByCheckWords(allReqParams.get("topictext")).size()<=0){
                    System.out.println("FLAG 1");
                    topicService.updateTopic(topic);
                }else{

                    model.addAttribute("ShowAlert",true);
                    model.addAttribute("topic_detail", topicService.getTopic(t_id));
                    Topic topics = topicService.getTopic(t_id);
                    model.addAttribute("category_detail",topicService.getCategory());
//                model.addAttribute("categorys",topicService.getCategory());
                    return "topic/topic-form-update";
                }
            }
//            topicService.updateTopic(topic);
        }
        return "redirect:/update";
    }
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @GetMapping("/{id}/delete")
    public String deleteTopic(@PathVariable("id") int id) {
        topicService.deleteTopic(id);

        return "redirect:/update";
    }
    @GetMapping("/{id}/view-qfaqs")
    public String TopicViewQFAQ(@PathVariable("id") int id, Model model) {
        Topic topic = topicService.getTopic(id);
        model.addAttribute("title", title + " - รายการคำถาม");
        model.addAttribute("topic", topic);
        model.addAttribute("qfaq", topic.getQfaqs());
        return "topic/topic-view-qfaqs";
    }
    @GetMapping("/{id}/qfaq/add")
    public String showQFAQForAdd(@PathVariable("id") int id, Model model) {
        Topic topic = topicService.getTopic(id);
        List<QFAQ> qfaq = qfaqService.getQFAQDoesNotHaveTopic(id);
        model.addAttribute("title", "เพิ่มคำถาม");
        model.addAttribute("topic", topic);
        model.addAttribute("qfaq", qfaq);
        return "topic/qfaq-list";
    }
    @PostMapping("/{id}/qfaq/add")
    public String addQFAQ(@PathVariable("id") int topicId, @RequestParam("qfaq") int qfaqId) {
        topicService.addQFAQToTopic(topicId, qfaqId);
        return "redirect:/topic/" + topicId + "/qfaq/add";
    }
    @GetMapping("/{id}/qfaq/{qfaq}/remove")
    public String topicRemoveQFAQ(@PathVariable("id") int topicId, @PathVariable("qfaq") int qfaqId) {
        topicService.removeQFAQFromTopic(topicId, qfaqId);
        return "redirect:/topic/" + topicId + "/view-qfaqs";
    }

}
