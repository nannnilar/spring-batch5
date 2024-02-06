package com.example.bootjpa.dao;

import com.example.bootjpa.entity.Student;

public interface CustomRepo {

    Student findtStudentCompleteName(String firstName,String lastName);
}
