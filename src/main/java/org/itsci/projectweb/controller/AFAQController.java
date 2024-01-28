package org.itsci.projectweb.controller;

import org.itsci.projectweb.model.AFAQ;
import org.itsci.projectweb.model.Topic;
import org.itsci.projectweb.service.AFAQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/afaq")
public class AFAQController {

    @Autowired
    private AFAQService afaqService;

    @RequestMapping("/add-afaq-page/{qfaqId}")
    public String goToAddAFAQPageWithQFAQId (@PathVariable("qfaqId") String qfaqId, Model model) {
        model.addAttribute("qfaqId", qfaqId);
        return "afaq/afaq-form";
    }

    @PostMapping("/save")
    public String saveAFAQ (@RequestParam Map<String, String> map, Model model) {
        afaqService.saveAFAQ(map);
        return "redirect:/update-page";
    }

    @RequestMapping("/update/{afaqId}")
    public String goToUpdateAFAQPage (@PathVariable("afaqId") String afaqId, Model model) {
        AFAQ afaq = afaqService.getAFAQById(afaqId);
        model.addAttribute("afaq", afaq);
        return "afaq/afaq-form-update";
    }

    @PostMapping("/update")
    public String updateAFAQ (@RequestParam Map<String, String> map) {
        afaqService.updateAFAQ(map);
        return "redirect:/update-page";
    }

    @RequestMapping("/delete/{afaqId}")
    public String deleteAFAQ (@PathVariable("afaqId") String afaqId) {
        afaqService.deleteAFAQ(afaqId);
        return "redirect:/update-page";
    }

}
