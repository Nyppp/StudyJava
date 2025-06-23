package com.example.spring_day3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @GetMapping("/users/{id}/posts/{postId}")
    public String getUserInfo(
            @PathVariable String id,
            @PathVariable Long postId,
            Model model){
        model.addAttribute("userId", id);
        model.addAttribute("postId", postId);
        model.addAttribute("message", postId + "번 사용자 정보입니다.");

        return "user-info";
    }
}
