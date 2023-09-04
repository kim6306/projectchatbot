package org.itsci.projectweb.controller;

import org.itsci.projectweb.model.AFAQ;
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

@Controller
@RequestMapping("/afaq")
public class AFAQController {
    private String title = "คำตอบ";
    @Autowired
    private AFAQService afaqService;
    @Autowired
    private QFAQService qfaqService;
    @GetMapping("/list")
    public String listAFAQ(Model model) {
        model.addAttribute("title", "รายการ" + title);
        model.addAttribute("afaqs",afaqService.getAFAQ());
        return "afaq/list";
    }
    @GetMapping("/create")
    public String showFormForAdd(Model model) {
        model.addAttribute("title", "เพิ่ม" + title);
        model.addAttribute("afaq", new AFAQ());
        return "afaq/afaq-form";
    }
    @GetMapping("/{id}/update")
    public String showFormForUpdate(@PathVariable("id") int id, Model model) {
        AFAQ afaq = afaqService.getAFAQ(id);
        model.addAttribute("title", "แก้ไข" + title);
        model.addAttribute("afaq", afaq );
        return "afaq/afaq-form";
    }
    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String processForm(@Valid @ModelAttribute("afaq") AFAQ afaq, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "มีข้อผิดพลาดในการบันทึก" + title);
            return "afaq/afaq-form";
        } else {
            AFAQ entityAfaq = afaqService.getAFAQ(afaq.getId());
            if (entityAfaq != null) {
                afaqService.updateAFAQ(entityAfaq,afaq);
            } else {
                afaqService.saveAFAQ(afaq);
            }
            return "redirect:/afaq/list";
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
        return "redirect:/afaq/list";
    }

}
