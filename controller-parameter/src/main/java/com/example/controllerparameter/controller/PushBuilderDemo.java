package com.example.controllerparameter.controller;

import jakarta.servlet.http.PushBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PushBuilderDemo {
    @GetMapping("/actionJ/nopush")
    public String actionJNoPush(){
        return "images";
    }
    @GetMapping("/actionK/push")
    public String actionKPush(PushBuilder pushBuilder){
        if (pushBuilder != null) {
            pushBuilder.path("/img/b-module02.jpg").push();
            pushBuilder.path("/img/b-module05.jpg").push();
            pushBuilder.path("/img/b-module08.jpg").push();
        }
        return "images";
    }
}
