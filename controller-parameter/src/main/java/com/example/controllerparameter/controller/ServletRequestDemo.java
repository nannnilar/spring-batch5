package com.example.controllerparameter.controller;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ServletRequestDemo {
//    curl localhost:8080/actionC
    @GetMapping("/actionC")
    public String actionC(ServletRequest request){
        return String.format(
                "retrieved request with server port = [%s : %d ]",
                request.getServerName(),
                request.getServerPort()
        );
    }
    //    curl localhost:8080/actionD
    @GetMapping("/actionD")
    public void actionD(ServletRequest request, ServletResponse response) throws IOException {
        response.getOutputStream().println(
                String.format(
                        "retrieved request with server port = [%s : %d ]",
                        request.getServerName(),
                        request.getServerPort()
                )
        );
    }
}
