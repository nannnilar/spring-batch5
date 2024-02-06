package com.example.springsecuritymaster.dao;

import com.example.springsecuritymaster.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee,Integer> {
}
