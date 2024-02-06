package com.example.authorizationdemo.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
    @GetMapping("/a")
    public String works1(){
        return "Works!";
    }
    @PostMapping("/a")
    public String works2(){
        return "Works!!!";
    }
    @GetMapping("/a/b")
    public String works3(){
        return "Works!";
    }
    @GetMapping("/a/b/c")
    public String works4(){
        return "Works!";
    }
}
