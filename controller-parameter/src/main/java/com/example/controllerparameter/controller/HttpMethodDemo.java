package com.example.controllerparameter.controller;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpMethodDemo {
//    curl -X POST localhost:8080/actionG
    @RequestMapping("/actionG")
    public String actionG(HttpMethod method){
        return String.format("Http Method : [%s]",method);
    }
}
