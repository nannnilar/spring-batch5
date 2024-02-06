package com.example.controllerparameter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import static com.example.controllerparameter.util.JoinUtil.*;

@RestController
public class WebRequestDemo {
//    curl "http://localhost:8080/actionA?city=Yangon&state=Yangon"
//    curl "http://localhost:8080/actionA?name=Flora+Kite&hobbby=reading"
    @GetMapping("/actionA")
    public String actionA(WebRequest request){
        return String.format("retrieved request with headers = [%], parameters = [%s]",
                join(request.getHeaderNames()),
                join(request.getParameterNames()));
    }
}
