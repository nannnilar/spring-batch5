package com.example.dockermysqlcomposer.controller;

import com.example.dockermysqlcomposer.dao.EmployeeDao;
import com.example.dockermysqlcomposer.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class EmployeeController {

    private final EmployeeDao employeeDao;
    @GetMapping("/employees")
    public List<Employee> listEmployee(){
        return employeeDao.findAll();
    }
    @GetMapping("/create")
    public String createEmploye(){
            List.of(
                    new Employee("John","Doe",2000,"john@gmail.com") ,
                    new Employee("John","William",2500,"william@gmail.com")
            ).forEach(employeeDao::save);
       return "Successfully Created.";
    }

}
