package com.example.mongodb.repository;

import com.example.mongodb.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StudentRepository extends MongoRepository<Student,String> {

    List<Student> findByName(String name);
}
