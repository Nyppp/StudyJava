package com.example.spring_day7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private InMemoryUserDetailsManager inMemoryUserDetailsManager;

    private List<UserDetails> users = new ArrayList<>();

    @GetMapping({"/", "/home"})
    public String home(Principal principal, Model model){
        model.addAttribute("username", principal.getName());
        return "home";
    }
    @GetMapping("/admin")
    public String admin(Principal principal, Model model){
        model.addAttribute("username", principal.getName());
        return "admin";
    }

    @GetMapping("/login")
    public String login() { return "login"; }

    @GetMapping("/register")
    public String showRegisterForm() {return "register";}

    @PostMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String auth,
                           Model model){
        UserDetails user = User.withDefaultPasswordEncoder()
                .username(username)
                .password(password)
                .roles(auth)
                .build();
        inMemoryUserDetailsManager.createUser(user);
        users.add(user);

        return "redirect:/login?register";
    }

    @GetMapping("/member")
    public String showMember(Model model){
        model.addAttribute("users", users);

        return "member";
    }
}