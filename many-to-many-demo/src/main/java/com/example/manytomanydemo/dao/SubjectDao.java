package com.example.manytomanydemo.dao;

import com.example.manytomanydemo.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectDao extends JpaRepository<Subject,Integer> {
}
