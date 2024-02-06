package com.example.myservletframeworkspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    @GetMapping("/")
    public String test(){
        return "index";
    }
    @GetMapping("/addNumber")
    public String addNum(@RequestParam("num1") int num1,@RequestParam("num2") int num2,Model model){
        String result = String.format("%s + %s = [%s]",num1,num2,num1+num2);
        model.addAttribute("result",result);

        return "result";
    }
    @GetMapping("/square")
    public String square(@RequestParam("num") int num,Model model){
        String result = String.format("%s square = [%s]",num,num*num);
        model.addAttribute("result",result);

        return "result";
    }
}
