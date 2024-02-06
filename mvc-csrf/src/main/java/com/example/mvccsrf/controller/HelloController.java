package com.example.mvccsrf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    private Logger logger = LoggerFactory.getLogger(HelloController.class.getName());
    @PostMapping("/add/product")
    public String hello(@RequestParam("product") String name){
        logger.info("Product Name================:"+name);
        return "index";
    }


    @GetMapping("/home")
    public String home(){

        return "index";
    }
}
