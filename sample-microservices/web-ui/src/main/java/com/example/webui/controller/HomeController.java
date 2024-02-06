package com.example.webui.controller;

import com.example.ds.Addresses;
import com.example.ds.Employee;
import com.example.ds.Employees;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;

@Controller
@RequestMapping("/webui")
public class HomeController {
    @Value("http://localhost:8080")
    private String baseUrl;

    @GetMapping("/addresses")
    public String showAddresses(Model model){
        var responseEntity = restTemplate.getForEntity(baseUrl+ "/address/addresses", Addresses.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()){
            Addresses addresses = responseEntity.getBody();
            model.addAttribute("addresses",addresses.getList());
        }else {
            model.addAttribute("addresses",Collections.emptyList());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return "index";
    }

    @GetMapping("/employees")
    public String showEmployees(Model model){
        var responseEntity = restTemplate.getForEntity(baseUrl+ "/employee/employees", Employees.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()){
            Employees employees = responseEntity.getBody();
            model.addAttribute("employees",employees.getEmployees());
        }else {
            model.addAttribute("employees", Collections.emptyList());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return "index";
    }

    private RestTemplate restTemplate = new RestTemplate();
    @GetMapping("/")
    public String home(){
        return "index";
    }
}
