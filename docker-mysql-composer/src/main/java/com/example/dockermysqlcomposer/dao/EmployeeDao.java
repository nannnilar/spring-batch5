package com.example.dockermysqlcomposer.dao;

import com.example.dockermysqlcomposer.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee,Integer> {


}
