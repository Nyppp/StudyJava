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
public class AuthController {
    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String showLoginPage(Model model){
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model, HttpSession session){
        Optional<User> optionalUser = userService.findUserByUsername(username);

        if(optionalUser.isEmpty()){
            model.addAttribute("error", "존재하지 않는 사용자입니다.");
            return "login";
        }

        User user = optionalUser.get();

        if(user.getPassword().equals(password)){
            session.setAttribute("user", user);
            return "redirect:/";
        }else{
            model.addAttribute("error", "비밀번호가 틀렸습니다.");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(Model model, HttpSession session){
        session.removeAttribute("user");
        return "redirect:/";
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model){
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(@RequestParam String username,
                                  @RequestParam String password,
                                  Model model, HttpSession session){
        User user = new User(username, password);
        userService.saveUser(user);
        session.setAttribute("user", user);
        model.addAttribute("user", user);
        return "redirect:/";
    }
}
