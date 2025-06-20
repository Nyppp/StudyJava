package com.example.spring_boot_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello, Spring Boot!";
    }

    @GetMapping("/hello/{name}")
    public String helloName(@PathVariable String name){
        System.out.println("PathVariable : " + name);
        return "Hello, " + name + "!";
    }

    @GetMapping("/greet")
    public String greet(@RequestParam(defaultValue = "World") String name){
        System.out.println("RequestParam : " + name);
        return "Greetings, " + name + "!";
    }

    @GetMapping("/info")
    public java.util.Map<String, Object> getInfo(){
        java.util.Map<String, Object> info = new java.util.HashMap<>();
        info.put("application", "Spring Boot Demo");
        info.put("version", "1.0.0");
        info.put("timestamp", java.time.LocalDateTime.now());
        return info;
    }

}
