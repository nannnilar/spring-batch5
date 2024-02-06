package org.example.dao;

import org.example.ds.Student;

import java.util.Optional;

public interface MyRepoInterface {
    Student findStudentByFirstNameAndLastName(String firstName,String lastName);
}
