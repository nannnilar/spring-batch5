package com.example.manytomanydemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Student extends IdClass {
    private String name;
    private String school;
    @ManyToMany(mappedBy = "students")
    List<Subject> subjects = new ArrayList<>();

//    public void addSubject(Subject subject){
//        subjects.add(subject);
//    }

    public Student() {
    }

    public Student(String name, String school) {
        this.name = name;
        this.school = school;
    }
}
