package com.example.employeeservice.dao;

import com.example.employeeservice.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {
}
