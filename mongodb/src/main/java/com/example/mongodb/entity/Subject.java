package com.example.mongodb.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Subject {
    private String subjectName;
    private String description;
    private int duration;
    private double fees;

    public Subject(String subjectName, String description, int duration, double fees) {
        this.subjectName = subjectName;
        this.description = description;
        this.duration = duration;
        this.fees = fees;
    }
}
