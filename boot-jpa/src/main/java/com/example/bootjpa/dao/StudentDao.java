package com.example.bootjpa.dao;

import com.example.bootjpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student,Integer>,CustomRepo {

}
