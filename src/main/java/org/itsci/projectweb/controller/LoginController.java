package org.itsci.projectweb.controller;
import org.itsci.projectweb.model.Administrator;
import org.itsci.projectweb.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Enumeration;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private AdministratorService administratorService;

    @GetMapping("/login-page")
    public String loginPage(Model model) {
        return "login-page";
    }

    @PostMapping("/login")
    public String loginAndAuthorize(@RequestParam Map<String, String> map, HttpServletRequest request, Model model) {
        String username = map.get("username");
        String password = map.get("password");
        Administrator administrator = administratorService.getAdministratorByUsername(username);
        if (administrator != null && administrator.getPassword().equals(password)) {
            HttpSession session = request.getSession();
            //session.setMaxInactiveInterval(900000);
            session.setAttribute("administrator", administrator.getUsername());
            System.out.println("Admin name : " + administrator.getUsername());
            return "redirect:/";
        } else {
            System.out.println("Admin null");
            model.addAttribute("loginFailed", true);
            return loginPage(model);
        }
    }

    @GetMapping("/logout")
    public String logoutAndClearSession (HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("administrator");
        return "redirect:/";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied(Model model) {
        model.addAttribute("title", "Access Denied");
        return "access-denied";
    }
}