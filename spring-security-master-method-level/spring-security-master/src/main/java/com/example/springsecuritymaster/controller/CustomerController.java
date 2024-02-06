package com.example.springsecuritymaster.controller;

import com.example.springsecuritymaster.annotation.customer.CustomerCreate;
import com.example.springsecuritymaster.annotation.customer.CustomerDelete;
import com.example.springsecuritymaster.annotation.customer.CustomerRead;
import com.example.springsecuritymaster.dao.CustomerDao;
import com.example.springsecuritymaster.model.Customer;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerDao customerDao;
    @CustomerRead
    @GetMapping("/list-customers")
    public String findAllCustomer(Model model){
        model.addAttribute("customers",customerDao.findAll());
        return "customers";
    }
    @CustomerCreate
    @GetMapping("/customer-form")
    public String customerForm(Model model){
        model.addAttribute("customer",new Customer());
        return "customerForm";
    }
    @CustomerCreate
    @PostMapping("/save-customer")
    public String saveCustomer(@Valid Customer customer, BindingResult result){
        if(result.hasErrors()){
            return "customerForm";
        }
        customerDao.save(customer);
        return "redirect:/customer/list-customers";
    }
    @CustomerDelete
    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("id")int id){
        if(customerDao.existsById(id)){
            customerDao.deleteById(id);
        }
        else{
            throw new EntityNotFoundException(id + " Not Found!");
        }
        return "redirect:/customer/list-customers";
    }


}
