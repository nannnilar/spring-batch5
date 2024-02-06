package com.example.demofatjar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping(value = {"/welcome","/"})
    public  String welcome(){
        return "Hello World From Spring Boot!";
    }
}
