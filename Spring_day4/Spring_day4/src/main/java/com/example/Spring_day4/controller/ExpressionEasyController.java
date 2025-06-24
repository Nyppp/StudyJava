package com.example.Spring_day4.controller;

import com.example.Spring_day4.model.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExpressionEasyController {

    @GetMapping("/expressions-easy")
    public String show(Model model) {
        Profile profile = new Profile();
        profile.setName("Jin");
        profile.setAge(22);
        profile.setActive(true);

        model.addAttribute("profile", profile);
        model.addAttribute("page", "home");

        return "expressions_easy";
    }
}