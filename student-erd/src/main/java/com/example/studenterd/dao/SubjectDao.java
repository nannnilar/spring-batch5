package com.example.studenterd.dao;

import com.example.studenterd.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectDao extends JpaRepository<Subject,Integer> {
}
