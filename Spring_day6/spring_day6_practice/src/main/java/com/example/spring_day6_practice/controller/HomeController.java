package com.example.spring_day6_practice.controller;

import com.example.spring_day6_practice.model.User;
import com.example.spring_day6_practice.service.RecipeService;
import com.example.spring_day6_practice.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    RecipeService recipeService;

    @GetMapping("/")
    public String showHome(Model model, HttpSession session){
        return "redirect:/recipes";
    }


}
