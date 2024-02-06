package com.example.csrftoken.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "GET Hello";
    }

    @PostMapping("/hello")
    public String hello1(){
        return "POST Hello";
    }


}
