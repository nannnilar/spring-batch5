package com.jdc.request.testrequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("users")
public class UserController {

    @GetMapping
    User getRequest(@ModelAttribute("user") User user){
        return user;
    }
    @PostMapping
    User postRequest(User user){
        return user;
    }
    @ModelAttribute("user")
    User user(){
        var user = new User();
        user.setName("John");
        user.setEmail("01987654");
        user.setEmail("john@gmail.com");
        user.setRegisteredAt(LocalDate.of(2023,9,1));
        return user;

    }
}
