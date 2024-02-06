package com.example.authorizationdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello/greeting/sayhello")
    public String hello(){
        return "Hello!";
    }
    @GetMapping("/greeting/hello/saygreeting")
    public String greeting(){
        return "Good Day Sar!";
    }

    @GetMapping("/home")
    public String home(){
        return "Welcome to Home!!";
    }
}
