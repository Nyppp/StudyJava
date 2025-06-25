package com.example.JPA_practice.controller;

import com.example.JPA_practice.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @GetMapping("/api/user")
    public List<User> getAllUsers(){
        List<User> list = new ArrayList<>();
    }

    @PostMapping("/api/user")
    public String addUser(){

    }

}
