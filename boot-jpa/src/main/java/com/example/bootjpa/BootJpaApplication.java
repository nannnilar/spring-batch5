package com.example.bootjpa;

import com.example.bootjpa.dao.StudentDao;
import com.example.bootjpa.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootJpaApplication implements CommandLineRunner {
    private StudentDao studentDao;

    public BootJpaApplication(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public static void main(String[] args) {
        SpringApplication.run(BootJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Student s1 = new Student(1,"John","Doe","john@gmail.com");
        Student s2 = new Student(2,"Thomas","Hardy","thomas@gmail.com");
        Student s3 = new Student(3,"Charles","Dickens","charles@gmail.com");

        studentDao.save(s1);
        studentDao.save(s2);
        studentDao.save(s3);

        studentDao.findAll().forEach(System.out::println);
        System.out.println("Find Student First Name And Last Name");
        System.out.println(studentDao.findtStudentCompleteName("John","Doe"));
    }
}
