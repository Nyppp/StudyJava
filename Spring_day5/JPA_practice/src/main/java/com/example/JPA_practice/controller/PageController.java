package com.example.JPA_practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/user")
    public String showForm(){
        return "user-form";
    }
}
