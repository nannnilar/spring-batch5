package com.example.mongodb.dto;

import com.example.mongodb.entity.Department;
import com.example.mongodb.entity.Student;
import com.example.mongodb.entity.Subject;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;
@Data
public class StudentDto {

    private String id;
    private String name;
    private String email;

    private Department department;
    private List<Subject> subjects = new ArrayList<>();


}
