package com.example.spring_day3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductsController {
    @GetMapping("/categories/{categoryId}/products")
    public String getProductsByCategory(
            @PathVariable int categoryId,
            @RequestParam int page,
            @RequestParam String sortBy,
            Model model){

        //PathVariable > 반드시 값이 있어야함
        //RequestParam > 값이 없어도 됨

        model.addAttribute("categoryId", categoryId);
        model.addAttribute("message", categoryId+"번 카테고리, " + page + "번 페이지에서 " + sortBy + " 기준으로 정렬 중입니다.");

        return "product-page";
    }

}
