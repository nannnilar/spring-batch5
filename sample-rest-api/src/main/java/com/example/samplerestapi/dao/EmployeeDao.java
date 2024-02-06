package com.example.samplerestapi.dao;

import com.example.samplerestapi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
