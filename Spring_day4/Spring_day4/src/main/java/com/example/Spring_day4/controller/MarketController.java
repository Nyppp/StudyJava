package com.example.Spring_day4.controller;

import com.example.Spring_day4.model.Member;
import com.example.Spring_day4.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class MarketController {
    @GetMapping("/play")
    public String showModel(Model model){
        Member member = new Member();
        member.setName("홍길동");
        member.setEmail("hong@example.com");
        model.addAttribute("member", member);

        Order order = new Order();
        order.setId(20250624000L);
        order.setStatus("SHIPPED");
        order.setOrderedAt(LocalDateTime.now().minusDays(1));
        order.setItems(List.of("키보드","마우스","헤드셋"));

        model.addAttribute("order", order);
        return "playground";
    }
}
