package com.example.spring_day3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("message", "안녕하세요!");
        model.addAttribute("userName", "홍길동");

        return "hello"; //문자열 그대로 쓰는게 아니라, html파일을 로드함
    }
}
