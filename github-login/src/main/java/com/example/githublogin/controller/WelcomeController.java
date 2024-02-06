package com.example.githublogin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    private Logger logger = LoggerFactory.getLogger(WelcomeController.class.getName());
    @GetMapping("/")
    public String welcome(OAuth2AuthenticationToken token){
        logger.info(""+token.getPrincipal());
        return "home";
    }
}
