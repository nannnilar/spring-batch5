package com.example.springsecuritymaster.controller;

import com.example.springsecuritymaster.dao.CustomerDao;
import com.example.springsecuritymaster.model.Customer;
import com.example.springsecuritymaster.model.Employee;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerDao customerDao;

    @GetMapping("/list-customers")
    public ModelAndView listCustomers(){
        return new ModelAndView("customers",
                "customers",
                customerDao.findAll());
    }

    @PostMapping("/save-customer")
    public String saveCustomer(@Valid Customer customer, BindingResult result,
                               RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "customerForm";
        }
        customerDao.save(customer);
        redirectAttributes.addFlashAttribute("success",true);
        return "redirect:/customer/list-customers";
    }

    @GetMapping("/delete-customer")
    public String deleteCustomer(@RequestParam("id")int id){
        if(customerDao.existsById(id)){
            customerDao.deleteById(id);
        }
        else{
            throw new EntityNotFoundException(id + " Not Found");
        }
        return "redirect:/customer/list-customers";
    }

    @GetMapping("/customer-form")
    public ModelAndView customerForm(){
        return new ModelAndView("customerForm",
                "customer",new Customer());
    }

}
