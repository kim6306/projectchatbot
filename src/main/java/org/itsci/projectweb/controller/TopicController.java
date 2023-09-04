package org.itsci.projectweb.controller;

import org.itsci.projectweb.model.QFAQ;
import org.itsci.projectweb.model.Topic;
import org.itsci.projectweb.service.QFAQService;
import org.itsci.projectweb.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/topic")
public class TopicController {
    private String title = "หัวข้อ";
    @Autowired
    private TopicService topicService;
    @Autowired
    private QFAQService qfaqService;
    @GetMapping("/list")
    public String listTopic(Model model) {
        model.addAttribute("title", "รายการ" + title);
        model.addAttribute("topics", topicService.getTopics());
        return "topic/list";
    }
    @GetMapping("/create")
    public String showFormForAdd(Model model) {
        model.addAttribute("title", "เพิ่ม" + title);
        model.addAttribute("topic", new Topic());
        return "topic/topic-form";
    }
    @GetMapping("/{id}/update")
    public String showFormForUpdate(@PathVariable("id") int id, Model model) {
        Topic topic = topicService.getTopic(id);
        model.addAttribute("title", "แก้ไข" + title);
        model.addAttribute("topic", topic );
        return "topic/topic-form-update";
    }
    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String processForm(@Valid @ModelAttribute("topic") Topic topic, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "มีข้อผิดพลาดในการบันทึก" + title);
            return "topic/topic-form-update";
        } else {

            Topic entityTopic = topicService.getTopic(topic.getId());
            if (entityTopic != null) {
                topicService.updateTopic(entityTopic,topic);
            } else {
                System.out.println(topic.getTopictext());
                topicService.saveTopic(topic);
            }
            return "redirect:/topic/list";
        }
    }
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @GetMapping("/{id}/delete")
    public String deleteTopic(@PathVariable("id") int id) {
        topicService.deleteTopic(id);
        topicService.deleteQFAQ(id);
        return "redirect:/topic/list";
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
