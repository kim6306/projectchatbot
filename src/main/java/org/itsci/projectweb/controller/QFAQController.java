package org.itsci.projectweb.controller;

import org.itsci.projectweb.model.*;
import org.itsci.projectweb.service.AFAQService;
import org.itsci.projectweb.service.QFAQService;
import org.itsci.projectweb.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/qfaq")
public class QFAQController {

    @Autowired
    private TopicService topicService;

    @Autowired
    private QFAQService qfaqService;

    @Autowired
    private AFAQService afaqService;

    @GetMapping("/add-qfaq-page")
    public String goToAddQFAQPage (Model model) {
        model.addAttribute("topics",topicService.getAllTopics());
        return "qfaq/qfaq-form";
    }

    @GetMapping("/add-qfaq-page/{topicId}")
    public String goToAddQFAQPageWithTopicId (Model model, @PathVariable("topicId") String topicId) {
        model.addAttribute("topics",topicService.getAllTopics());
        model.addAttribute("topicId", topicId);
        Topic topic = topicService.getTopicById(Integer.parseInt(topicId));
        model.addAttribute("topicName",topic.getTopic_name());
        return "qfaq/qfaq-form";
    }

    @PostMapping("/save")
    public String saveQFAQ (@RequestParam Map<String, String> map, Model model ) {
        String topicid = map.get("topic_id");
        String qfaq = map.get("qfaqtext");
        String afaq = map.get("afaqtext");
        if (qfaqService.getQFAQsByCheckWords(qfaq).size()<=0){
            if (afaqService.getAFAQsByCheckWords(afaq).size()<=0){
                qfaqService.saveQFAQ(map);
            }
            else {
                model.addAttribute("ShowAlert2",true);
                model.addAttribute("topicId", topicid);
                return "qfaq/qfaq-form";
            }
        }
        else {
            model.addAttribute("ShowAlert1",true);
            model.addAttribute("topicId", topicid);
            return "qfaq/qfaq-form";
        }
        return "redirect:/update-page";
    }

    @RequestMapping("/update/{qfaqId}")
    public String goToUpdateQFAQPage (@PathVariable("qfaqId") String qfaqId, Model model) {
        QFAQ qfaq = qfaqService.getQFAQById(Integer.parseInt(qfaqId));
        model.addAttribute("qfaq", qfaq);
        model.addAttribute("topics", topicService.getAllTopics());
        return "qfaq/qfaq-form-update";
    }

    @PostMapping("/update")
    public String updateQFAQ (@RequestParam Map<String, String> map) {
        qfaqService.updateQFAQ(map);
        return "redirect:/update-page";
    }

    @RequestMapping("/delete/{qfaqId}")
    public String deleteQFAQ (@PathVariable("qfaqId") String qfaqId) {
        qfaqService.deleteQFAQ(Integer.parseInt(qfaqId));
        return "redirect:/update-page";
    }

}
