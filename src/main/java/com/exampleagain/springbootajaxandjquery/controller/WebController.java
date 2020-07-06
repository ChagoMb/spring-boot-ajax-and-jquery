package com.exampleagain.springbootajaxandjquery.controller;

import com.exampleagain.springbootajaxandjquery.model.User;
import com.exampleagain.springbootajaxandjquery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller("/")
public class WebController {

    private UserService service;

    private HttpSession session;


    @Autowired
    public WebController(UserService service, HttpSession session) {
        this.service = service;
        this.session = session;
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String postLogin() {
        return "redirect:/admin";
    }

    @GetMapping("/admin")
    public String admin(ModelMap model) {
        UserDetails userDetails = (UserDetails) session.getAttribute("username");
        User user = service.findUserByEmail(userDetails.getUsername());
        model.addAttribute("admin", user);
        model.addAttribute("user", user);

        List<User> users = service.findAllUsers();
        model.addAttribute("users", users);
        return "/admin/main-page";
    }

    @GetMapping("/admin/add")
    public String getAdd() {
        return "/admin/user-add";
    }


    @GetMapping("/admin/remove/{id}")
    public String remove(@PathVariable("id") long id) {
        service.removeUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/user")
    public String get(ModelMap model) {
        UserDetails userDetails = (UserDetails) session.getAttribute("username");
        User user = service.findUserByEmail(userDetails.getUsername());
        model.addAttribute("user", user);
        return "user-page";
    }
}
