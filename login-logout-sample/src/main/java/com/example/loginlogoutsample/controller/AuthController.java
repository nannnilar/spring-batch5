package com.example.loginlogoutsample.controller;

import com.example.loginlogoutsample.entity.Customer;
import com.example.loginlogoutsample.service.AuthService;
import com.example.loginlogoutsample.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @GetMapping("/signup")
    public String signUpForm(Model model){
        model.addAttribute("customer",new Customer());
        return "signup";
    }
    @PostMapping("/save")
    public String saveCustomer(Customer customer, BindingResult result){
        if (result.hasErrors()){
            return "signup";
        }
        authService.register(customer);
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/login-error")
    public String loginError(Model model){
        model.addAttribute("loginError",true);
        return "login";
    }
}
