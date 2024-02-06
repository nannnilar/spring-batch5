package com.example.studenterd.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String subjectName;
    private int duration;
    private double fees;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<StudentSubject> studentSubjects = new ArrayList<>();

    public void addStudentSubject(StudentSubject studentSubject){
        studentSubject.setSubject(this);
        this.studentSubjects.add(studentSubject);
    }

    public Subject() {
    }
    public Subject(String subjectName, int duration, double fees) {
        this.subjectName = subjectName;
        this.duration = duration;
        this.fees = fees;
    }
}
