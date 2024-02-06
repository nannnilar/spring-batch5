package com.example.statickeyfilter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
//    curl -H "Authorization: secret" localhost:8080/hello
    @GetMapping("/hello")
    public String hello(){
        return "Hello!";
    }
}
