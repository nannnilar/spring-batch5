package com.example.mongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "student")
public class Student {
    @Id
    private String id;
    private String name;
    private String email;

    public Student() {
    }
    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    private Department department;
    private List<Subject> subjects = new ArrayList<>();
    public void addSubject(Subject subject){
        this.subjects.add(subject);
    }
}
