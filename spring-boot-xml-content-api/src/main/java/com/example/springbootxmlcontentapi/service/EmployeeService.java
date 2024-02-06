package com.example.springbootxmlcontentapi.service;

import com.example.springbootxmlcontentapi.dao.EmployeeDao;
import com.example.springbootxmlcontentapi.enity.Employee;
import com.example.springbootxmlcontentapi.enity.Employees;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeDao employeeDao;

    public Employees findAllEmployees(){
        return new Employees(employeeDao.findAll());
    }

    public Employee findById(int id){
        return employeeDao.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
    public Employee saveEmployee(Employee employee){
       return employeeDao.save(employee);
    }
}
