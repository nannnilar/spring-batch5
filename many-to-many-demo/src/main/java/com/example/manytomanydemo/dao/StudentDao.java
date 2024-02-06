package com.example.manytomanydemo.dao;

import com.example.manytomanydemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student,Integer> {
}
