package com.example.manytomanydemo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Subject extends IdClass{
    private String subjectName;
    private int duration;
    private double price;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student){
        student.getSubjects().add(this);
        students.add(student);
    }

    public Subject(String subjectName, int duration, double price) {
        this.subjectName = subjectName;
        this.duration = duration;
        this.price = price;
    }
    public Subject() {
    }
}
