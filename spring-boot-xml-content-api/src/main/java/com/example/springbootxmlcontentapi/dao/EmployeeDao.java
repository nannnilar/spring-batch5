package com.example.springbootxmlcontentapi.dao;

import com.example.springbootxmlcontentapi.enity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee,Integer> {
}
