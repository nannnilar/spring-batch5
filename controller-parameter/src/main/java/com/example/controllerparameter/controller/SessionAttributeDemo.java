package com.example.controllerparameter.controller;

import com.example.controllerparameter.ds.Address;
import com.example.controllerparameter.ds.Employee;
import com.example.controllerparameter.ds.Experties;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes({"employee","address","experties"})
public class SessionAttributeDemo {
    @GetMapping("/employee-form")
    public String employeeForm(@ModelAttribute("employee")Employee employee, Model model){
        model.addAttribute("employee",employee);
        return "employeeForm";
    }
    @PostMapping("/save-employee")
    public String processEmployeeForm(@ModelAttribute("employee")Employee employee){
        return "redirect:/addressForm";
    }
    @GetMapping("/addressForm")
    public String addressForm(@ModelAttribute ("address")Address address,Model model){
        model.addAttribute("address",address);
        return "addressForm";
    }
    @PostMapping("/save-address")
   public String processAddress(@ModelAttribute ("address")Address address){
        return "redirect:/expertiesForm";
   }
    @GetMapping("/expertiesForm")
    public String expertiesForm(@ModelAttribute ("experties")Experties experties,Model model){
        model.addAttribute("experties",experties);
        return "expertiesForm";
    }
    @PostMapping("/save-experties")
    public String  processExperties(@ModelAttribute ("experties")Experties experties){
        return "redirect:/info";
    }
    @GetMapping("/info")
    public String info(@ModelAttribute ("experties")Experties experties,
                       @ModelAttribute ("address")Address address,
                       @ModelAttribute("employee")Employee employee,
                       Model model, SessionStatus sessionStatus){
        model.addAttribute("experties",experties);
        model.addAttribute("address",address);
        model.addAttribute("employee",employee);
        sessionStatus.setComplete();
        return "info";
    }

    @ModelAttribute("experties")
    public Experties experties(){
        return new Experties();
    }
    @ModelAttribute("address")
    public Address address(){
        return new Address();
    }

    @ModelAttribute("employee")
    public Employee employee(){
        return new Employee();
    }


}
