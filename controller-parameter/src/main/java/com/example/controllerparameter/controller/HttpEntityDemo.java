package com.example.controllerparameter.controller;

import com.example.controllerparameter.ds.Employee;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpEntityDemo {
//    curl -X POST -H "Content-Type: application/json" -d '{"firstName":"John","lastName":"Doe","email":"john@gmail.com"}' localhost:8080/actionL
    @PostMapping("/actionL")
    public String actionL(HttpEntity<Employee> employeeHttpEntity){
        return String.format(
                "receive from HttpEntity %s.",employeeHttpEntity.getBody()
        );
    }
}
