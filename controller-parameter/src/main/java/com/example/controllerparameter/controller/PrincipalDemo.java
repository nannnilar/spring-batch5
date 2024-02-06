package com.example.controllerparameter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Optional;

@RestController
public class PrincipalDemo {
    private String userName;
//    curl -v localhost:8080/actionF
//    curl -u user:2cf3382f-b69d-4534-8cd8-1d96dce65549 localhost:8080/actionF
    @GetMapping("/actionF")
    public String actionF(Principal principal){

        Optional.ofNullable(principal).ifPresentOrElse(p -> {
            userName = p.getName();
        }, () -> {
            userName = "Default Name";
        });

        return String.format(
                "authentication with principal : [%s]",
               userName
        );
    }
}
