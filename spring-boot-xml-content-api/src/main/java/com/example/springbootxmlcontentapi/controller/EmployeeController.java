package com.example.springbootxmlcontentapi.controller;

import com.example.springbootxmlcontentapi.enity.Employee;
import com.example.springbootxmlcontentapi.enity.Employees;
import com.example.springbootxmlcontentapi.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping(value = "/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public Employees listEmployees(){
        return employeeService.findAllEmployees();
    }
//    employee/all.json, employee/all.xml
    @GetMapping("all.{type}")
    public ResponseEntity<Employees> employeesList(@PathVariable("type") String type){
        if ("xml".equalsIgnoreCase(type)){
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_XML)
                    .body(new Employees(employeeService.findAllEmployees().getEmployees()));
        }
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(new Employees(employeeService.findAllEmployees().getEmployees()));
    }
//    curl -H "Accept:application/xml" localhost:8080/employee/1
    @GetMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Employee findEmployeeById(@PathVariable("id")int id){
        return employeeService.findById(id);
    }
//    curl
    @PostMapping(value = "/all",consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity createEmployee(@RequestBody Employee employee){
        Employee manageEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.created(URI.create("http://localhost:8080/employee/"+
                manageEmployee.getId())).body(manageEmployee);
    }
}
