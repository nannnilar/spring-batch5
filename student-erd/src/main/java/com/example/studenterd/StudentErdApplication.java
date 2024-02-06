package com.example.studenterd;

import com.example.studenterd.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentErdApplication implements CommandLineRunner {

    private final StudentService studentService;

    public StudentErdApplication(StudentService studentService) {
        this.studentService = studentService;
    }

    public static void main(String[] args) {
        SpringApplication.run(StudentErdApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        studentService.createDb();
        JPAUtil.checkData("select * from province");
        JPAUtil.checkData("select * from student");
        JPAUtil.checkData("select * from student_subject");
        JPAUtil.checkData("select * from subject");
    }
}
