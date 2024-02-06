package com.example.springsecuritymaster.dao;

import com.example.springsecuritymaster.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentDao extends JpaRepository<Department,Integer> {
}
