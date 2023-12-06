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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/qfaq")
public class QFAQController {
    private String title = "คำถาม";
    @Autowired
    private TopicService topicService;
    @Autowired
    private AFAQService afaqService;
    @Autowired
    private QFAQService qfaqService;
    @GetMapping("/list")
    public String listQFAQ(Model model) {
        model.addAttribute("title", "รายการ" + title);
        model.addAttribute("qfaqs", qfaqService.getQFAQ());
        model.addAttribute("topics",topicService.getTopics());
        return "qfaq/list";
    }
    @GetMapping("/create")
    public String showFormForAdd(Model model) {
        model.addAttribute("title", "เพิ่ม" + title);
        model.addAttribute("qfaqafaq" ,new QfaqAfaqDTO());
        model.addAttribute("topics",topicService.getTopics());
        return "qfaq/qfaq-form";
    }

    @GetMapping("/create/{topicName}")
    public String showFormForAddWithTopic(Model model, @PathVariable("topicName") String topicName) {
        model.addAttribute("title", "เพิ่ม" + title);
        model.addAttribute("qfaqafaq" ,new QfaqAfaqDTO());
        model.addAttribute("topics",topicService.getTopics());
        System.out.println(topicName);
        return "qfaq/qfaq-form";
    }

    @GetMapping("/{id}/update")
    public String showFormForUpdate(@PathVariable("id") int id, Model model) {
        QFAQ qfaq = qfaqService.getQFAQ(id);
        List<Topic> topics = topicService.getTopics();
        model.addAttribute("title", "แก้ไข" + title);
        model.addAttribute("qfaq", qfaq );
        model.addAttribute("topics",topics);
//        model.addAttribute("ShowAlert1", null);
        return "qfaq/qfaq-form-update";
    }
    @GetMapping(path = "/save")
    public String processForm(@ModelAttribute("qfaqafaq") QfaqAfaqDTO qfaqAfaqDTO,Model model) {
        String qfaq = qfaqAfaqDTO.getQfaqtext();
        String afaq = qfaqAfaqDTO.getAfaqtext();
        int topicid = qfaqAfaqDTO.getTopicid();
        if (qfaqService.getQFAQsByCheckWords(qfaq).size()<=0){
            if (afaqService.getAFAQsByCheckWords(afaq).size()<=0){
                qfaqService.saveqfaqwithafaq(qfaq,afaq,topicid);
            }
            else {
                model.addAttribute("ShowAlert2",true);
                model.addAttribute("topics",topicService.getTopics());
                return "qfaq/qfaq-form";
            }
        }
        else {
            model.addAttribute("ShowAlert1",true);
            model.addAttribute("topics",topicService.getTopics());
            return "qfaq/qfaq-form";
        }
        System.out.println("test1:"+topicid);
        System.out.println("test2:"+qfaq);
        System.out.println("test3:"+afaq);
        return "redirect:/update";
    }
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @GetMapping("/{id}/delete")
    public String deleteQFAQ(@PathVariable("id") int id) {
        qfaqService.deleteQFAQ(id);
        return "redirect:/update";
    }
    @GetMapping("/{id}/view-afaqs")
    public String QFAQViewAFAQ(@PathVariable("id") int id, Model model) {
        QFAQ qfaq = qfaqService.getQFAQ(id);
        model.addAttribute("title", title + " - รายการคำตอบ");
        model.addAttribute("qfaq", qfaq);
        model.addAttribute("afaq", qfaq.getAfaqs());
        return "qfaq/qfaq-view-afaqs";
    }
    @GetMapping("/{id}/afaq/add")
    public String showAFAQForAdd(@PathVariable("id") int id, Model model) {
        QFAQ qfaq = qfaqService.getQFAQ(id);
        List<AFAQ> afaq = afaqService.getAFAQDoesNotHaveQFAQ(id);
        model.addAttribute("title", "เพิ่มคำถาม");
        model.addAttribute("qfaq", qfaq);
        model.addAttribute("afaq", afaq);
        return "qfaq/afaq-list";
    }
    @PostMapping("/{id}/afaq/add")
    public String addAFAQ(@PathVariable("id") int qfaqId, @RequestParam("afaq") int afaqId) {
        qfaqService.addQFAQToAFAQ(qfaqId,afaqId);
        return "redirect:/qfaq/" + qfaqId + "/afaq/add";
    }
    @GetMapping("/{id}/afaq/{afaq}/remove")
    public String QFAQRemoveAFAQ(@PathVariable("id") int qfaqId, @PathVariable("afaq") int afaqId) {
        qfaqService.removeQFAQFromAFAQ(qfaqId,afaqId);
        return "redirect:/qfaq/" + qfaqId + "/view-afaqs";
    }
    @RequestMapping(path = "/{q_id}/saveupdate")
    public String processForm(@RequestParam Map<String, String> allReqParams, @PathVariable int q_id, Model model) {

        QFAQ qfaq = qfaqService.getQFAQ(q_id);
        if (qfaq != null){

            qfaq.setQfaq_name(allReqParams.get("qfaqtext"));
            System.out.println("QFAQ : " + allReqParams.get("qfaqtext"));
            String topic_id = allReqParams.get("topic_id");
            Topic topic = topicService.getTopic(Integer.parseInt(topic_id));
            if (topic != null){
                qfaq.setTopic(topic);
                List<QFAQ> remainQFAQ = qfaqService.getQFAQsByCheckWords(qfaq.getQfaq_name());
                if (remainQFAQ.size() > 0) {
                    remainQFAQ.removeIf(qfaq1 -> qfaq1.getQfaq_id() == qfaq.getQfaq_id());
                }

                System.out.println("REM SIZE : " + remainQFAQ.size());
                if (remainQFAQ.size() == 0) {

                    qfaqService.updateQFAQ2(qfaq);
                    return "redirect:/update";
                }
                else {
                    model.addAttribute("ShowAlert3",true);
                    model.addAttribute("ShowAlert2",true);
                    model.addAttribute("qfaq", qfaq );
                    System.out.println("OLD QFAQ : " + qfaq.getQfaq_name());
                    return "redirect:/qfaq/" + qfaq.getQfaq_id() + "/update";
                }
            }
        }
        return "redirect:/update";
    }
}
