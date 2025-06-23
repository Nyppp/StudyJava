package com.example.spring_day3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
    @GetMapping("/search")
    public String hello(@RequestParam String keyword, Model model){
        model.addAttribute("searchKeyword", keyword);
        model.addAttribute("message", keyword + "에 대한 검색 결과입니다.");

        return "search-result"; //문자열 그대로 쓰는게 아니라, html파일을 로드함
    }
}
