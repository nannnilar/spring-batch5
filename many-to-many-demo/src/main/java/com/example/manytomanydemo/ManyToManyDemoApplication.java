package com.example.manytomanydemo;

import com.example.manytomanydemo.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManyToManyDemoApplication implements CommandLineRunner {

    private final StudentService studentService;
    public ManyToManyDemoApplication(StudentService studentService) {
        this.studentService = studentService;
    }
    public static void main(String[] args) {
        SpringApplication.run(ManyToManyDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        studentService.createDb();
        JPAUtil.checkData("select * from student");
        JPAUtil.checkData("select * from subject");
        JPAUtil.checkData("select * from subject_students");
    }
}
