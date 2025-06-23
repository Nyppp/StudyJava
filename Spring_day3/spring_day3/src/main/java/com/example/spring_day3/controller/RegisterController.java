package com.example.spring_day3.controller;

import com.example.spring_day3.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {
    //하나의 페이지에 GET / POST 요청 시 동작할 기능 구현 가능

    @GetMapping("/register")
    public String registerForm(){
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("message", "회원 가입이 완료되었습니다.");

        return "register-success";
    }
}
