package com.example.Spring_day4.controller;

import com.example.Spring_day4.model.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

//해당 코드에서는 요청에 대한 처리만 담당,
//페이지 렌더링은 PageController에서 처리 > 데이터 처리와 View 처리 분리

@Controller
public class RegisterController {
    @GetMapping("/register")
    public String getRegisterForm(){
        return "register";
    }

    @PostMapping("/register")
    public String postRegisterForm(
            @ModelAttribute UserDTO user,
            Model model){
        model.addAttribute("message", user.getName()+"님, 가입을 환영합니다!");

        return "register-success";
    }
}
