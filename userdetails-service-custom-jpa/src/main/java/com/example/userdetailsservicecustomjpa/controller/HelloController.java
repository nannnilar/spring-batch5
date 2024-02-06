package com.example.userdetailsservicecustomjpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "Hello!";
    }
    @GetMapping("/greet")
    public String greet(){
        return "Hey! how's it going?";
    }
}
