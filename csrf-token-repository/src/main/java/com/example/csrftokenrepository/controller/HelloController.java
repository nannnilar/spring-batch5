package com.example.csrftokenrepository.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(HttpServletRequest request){
        CsrfToken csrfToken = (CsrfToken) request.getAttribute("_csrf");
        Logger logger = LoggerFactory.getLogger(HelloController.class.getName());
        logger.info("CSRF Token ===================:"+csrfToken.getToken());
        return "GET Hello!";
    }
    @PostMapping("/hello")
    public String hello2(){
        return "POST Hello!";
    }
}
