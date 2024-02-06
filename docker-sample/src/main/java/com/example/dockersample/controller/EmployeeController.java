package com.example.dockersample.controller;

import com.example.dockersample.dao.EmployeeDao;
import com.example.dockersample.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeDao employeeDao;
    @GetMapping("/employees")
    public List<Employee> listEmployee(){
        return employeeDao.findAll();
    }
}
