package com.example.controllerparameter.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpSessionDemo {
//    curl -c cookie.txt -b cookie.txt  localhost:8080/actionE
    @GetMapping("actionE")
    public String actionE(HttpSession session){
        Integer counter = (Integer) session.getAttribute("counter");
        if (counter == null){
            session.setAttribute("counter",0);
            counter = 0;
        }
        session.setAttribute("counter", ++counter);
        return String.format(
                "Counter = [%d]",counter
        );
    }
}
