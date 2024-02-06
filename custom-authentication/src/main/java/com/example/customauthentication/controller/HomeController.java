package com.example.customauthentication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home(){
        return "home.html";
    }
    @GetMapping("/errorOne")
    public String error(){
        return "error-one.html";
    }
}
