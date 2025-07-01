package com.example.spring_day8.controller;

import com.example.spring_day8.model.User;
import com.example.spring_day8.servcie.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class AuthController {
    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String showLoginPage() { return "login"; }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username,
                            @RequestParam String password,
                            Model model, HttpSession session){
        Optional<User> userOptional = userService.findUserByUserName(username);

        if(userOptional.isEmpty()){
            model.addAttribute("error", "존재하지 않는 사용자입니다.");
            return "login";
        }

        User user = userOptional.get();

        if(!user.getPassword().equals(password)){
            model.addAttribute("error", "비밀번호가 틀렸습니다.");
            return "login";
        }

        session.setAttribute("user", user);
        return "redirect:/";

    }

    @GetMapping("/register")
    public String showRegisterPage() { return "register"; }

    @PostMapping("/register")
    public String addNewUser(@RequestParam String username,
                             @RequestParam String password,
                             Model model,
                             HttpSession session){
        User user = new User(username, password);
        userService.saveUser(user);
        session.setAttribute("user", user);
        model.addAttribute("user", user);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logoutUser(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/";
    }
}
