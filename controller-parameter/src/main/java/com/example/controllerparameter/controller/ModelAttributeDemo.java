package com.example.controllerparameter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class ModelAttributeDemo {
    @GetMapping("/hello")
    public String hello(@ModelAttribute("subjects") List<String> list, Model model){
        model.addAttribute("mySubject",list);
        return "hello";
    }
    @GetMapping("/hello2")
    public String helloV2(){
        return "hello2";
    }
    @ModelAttribute("subjects")
    private List subjects(){
        return List.of("Java","Groovy","Scala","Python","Angular");
    }
}
