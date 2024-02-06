package com.example.customauthentication.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        return "Hello!" + authentication.getName();
    }

    @Async
    @GetMapping("/goodbye")
    public void sayGoodBye(){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        System.out.println("goodBye!"+authentication.getName());
    }

    @GetMapping("/greet")
    public String greet() throws Exception{
        Callable<String > callable = () ->{
            return SecurityContextHolder.getContext().getAuthentication().getName();
        };
        ExecutorService  executorService = Executors.newCachedThreadPool();
        try{
            return "Hello! " + executorService.submit(callable).get() + " from Executor Service";
        } finally {
            executorService.shutdown();
        }
    }



}
