package org.itsci.projectweb.controller;

import org.itsci.projectweb.model.AFAQ;
import org.itsci.projectweb.model.QFAQ;
import org.itsci.projectweb.service.AFAQService;
import org.itsci.projectweb.service.QFAQService;
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
@RequestMapping("/qfaq")
public class QFAQController {
    private String title = "คำถาม";
    @Autowired
    private AFAQService afaqService;
    @Autowired
    private QFAQService qfaqService;
    @GetMapping("/list")
    public String listQFAQ(Model model) {
        model.addAttribute("title", "รายการ" + title);
        model.addAttribute("qfaqs", qfaqService.getQFAQ());
        return "qfaq/list";
    }
    @GetMapping("/create")
    public String showFormForAdd(Model model) {
        model.addAttribute("title", "เพิ่ม" + title);
        model.addAttribute("qfaq", new QFAQ());
        return "qfaq/qfaq-form";
    }
    @GetMapping("/{id}/update")
    public String showFormForUpdate(@PathVariable("id") int id, Model model) {
        QFAQ qfaq = qfaqService.getQFAQ(id);
        model.addAttribute("title", "แก้ไข" + title);
        model.addAttribute("qfaq", qfaq );
        return "qfaq/qfaq-form-update";
    }
    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String processForm(@Valid @ModelAttribute("qfaq") QFAQ qfaq, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "มีข้อผิดพลาดในการบันทึก" + title);
            return "qfaq/qfaq-form-update";
        } else {
            QFAQ entityQfaq = qfaqService.getQFAQ(qfaq.getId());
            if (entityQfaq != null) {
                qfaqService.updateQFAQ(entityQfaq,qfaq);
                return "redirect:/update";
            } else {
                qfaqService.saveQFAQ(qfaq);
            }
            return "redirect:/afaq/create";
        }
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
}
