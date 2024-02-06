package com.example.loginlogoutsample.controller;

import com.example.loginlogoutsample.entity.Customer;
import com.example.loginlogoutsample.service.CustomerService;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @RolesAllowed({"SUPER_ADMIN","MANAGER"})
    @GetMapping("/create")
    public String customerForm(Model model){
        model.addAttribute("customer",new Customer());
        return "customerForm";
    }

    @RolesAllowed({"SUPER_ADMIN","MANAGER"})
    @PostMapping("/save")
    public String saveCustomer(Customer customer, BindingResult result){
        if (result.hasErrors()){
            return "customerForm";
        }
        customerService.saveCustomer(customer);
        return "redirect:/customer/customers";
    }
    @GetMapping("/customers")
    public String listCustomers(Model model){
        model.addAttribute("customers",customerService.findAllCustomers());
        return "customers";
    }
}
