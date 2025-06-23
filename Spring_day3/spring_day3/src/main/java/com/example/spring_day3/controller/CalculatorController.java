package com.example.spring_day3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/calculate")
    public String hello(
            @RequestParam int num1,
            @RequestParam int num2,
            @RequestParam String operator,
            Model model){

        switch (operator){
            case "+":
                model.addAttribute("result", num1 + " + " + num2 + " = " + (num1 + num2));
                break;
            case "-":
                model.addAttribute("result", num1 + " - " + num2 + " = " + (num1 - num2));
                break;
            case "*":
                model.addAttribute("result", num1 + " * " + num2 + " = " + (num1 * num2));
                break;
            case "/":
                if(num2 == 0){
                    model.addAttribute("result", "0으로 나눗셈은 불가합니다.");
                    break;
                }
                model.addAttribute("result", num1 + " / " + num2 + " = " + (num1 / num2));
                break;
            case " ":
                model.addAttribute("result", num1 + " + " + num2 + " = " + (num1 + num2));
                break;
            default:
                model.addAttribute("result", "올바르지 않은 연산자 입력입니다.");
                break;
        }

        return "calculator"; //문자열 그대로 쓰는게 아니라, html파일을 로드함
    }
}
