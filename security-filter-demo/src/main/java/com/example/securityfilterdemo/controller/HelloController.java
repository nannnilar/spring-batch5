package com.example.securityfilterdemo.controller;

import org.springframework.security.web.FilterChainProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
//    curl -H "request-id:apple" -u john:12345 localhost:8080/hello
    @GetMapping("/hello")
    public String hello(){
        return "Hello!";
    }

}
