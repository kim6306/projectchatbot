package org.itsci.projectweb.controller;

import org.itsci.projectweb.model.AFAQ;
import org.itsci.projectweb.model.AfaqQfaqDTO;
import org.itsci.projectweb.model.QFAQ;
import org.itsci.projectweb.model.QfaqAfaqDTO;
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

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/afaq")
public class AFAQController {
    private String title = "คำตอบ";
    @Autowired
    private TopicService topicService;
    @Autowired
    private AFAQService afaqService;
    @Autowired
    private QFAQService qfaqService;
    @GetMapping("/list")
    public String listAFAQ(Model model) {
        model.addAttribute("title", "รายการ" + title);
        model.addAttribute("afaqs",afaqService.getAFAQ());
        model.addAttribute("qfaqs", qfaqService.getQFAQ());
        model.addAttribute("topics",topicService.getTopics());
        return "afaq/list";
    }
    @GetMapping("/create")
    public String showFormForAdd(Model model) {
        model.addAttribute("title", "เพิ่ม" + title);
        model.addAttribute("afaqqfaq", new AfaqQfaqDTO());
        model.addAttribute("qfaqs",qfaqService.getQFAQ());
        return "afaq/afaq-form";
    }
    @GetMapping("/{id}/update")
    public String showFormForUpdate(@PathVariable("id") int id, Model model) {
        AFAQ afaq = afaqService.getAFAQ(id);
        model.addAttribute("title", "แก้ไข" + title);
        model.addAttribute("afaq", afaq );
        return "afaq/afaq-form-update";
    }
    @RequestMapping(path = "/saveupdate", method = RequestMethod.POST)
    public String processForm(@Valid @ModelAttribute("afaq") AFAQ afaq, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "มีข้อผิดพลาดในการบันทึก" + title);
            return "afaq/afaq-form";
        } else {
            AFAQ entityAfaq = afaqService.getAFAQ(afaq.getAfaq_id());

            //Check new afaq is left on old db
            List<AFAQ> remainAFAQ = afaqService.getAFAQsByCheckWords(afaq.getAfaq_name());

            if (remainAFAQ.size() > 0) {
                remainAFAQ.removeIf(afaq1 -> afaq1.getAfaq_id() == afaq.getAfaq_id());
            }

//            System.out.println("REM SIZE : " + remainAFAQ.size());

            if (remainAFAQ.size() == 0) {
                afaqService.updateAFAQ(entityAfaq,afaq);
                return "redirect:/afaq/list";
            } else {
                model.addAttribute("ShowAlert", true);
                model.addAttribute("afaq", afaq );
                System.out.println("OLD AFAQ : " + afaq.getAfaq_name());
                return "redirect:/afaq/" + afaq.getAfaq_id() + "/update";
            }
        }
    }
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @GetMapping("/{id}/delete")
    public String deleteAFAQ(@PathVariable("id") int id) {
        afaqService.deleteAFAQ(id);
        return "redirect:/update";
    }
    @GetMapping(path = "/save")
    public String processForm(@ModelAttribute("afaqqfaq") AfaqQfaqDTO afaqQfaqDTO,Model model) {
        String afaq = afaqQfaqDTO.getAfaqtext();
        int qfaqid = afaqQfaqDTO.getQfaqid();
        if (afaqService.getAFAQsByCheckWords(afaq).size()<=0){
            afaqService.saveafaqwithqfaq(afaq,qfaqid);
        }
        else {
            model.addAttribute("ShowAlert2",true);
            model.addAttribute("qfaqs",qfaqService.getQFAQ());
            return "afaq/afaq-form";
        }

        System.out.println("test1:"+qfaqid);
//        System.out.println("test2:"+qfaq);
        System.out.println("test3:"+afaq);
        return "redirect:/update";
    }

}
