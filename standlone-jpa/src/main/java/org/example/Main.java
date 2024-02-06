package org.example;

import org.example.service.StudentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();
        StudentService service = context.getBean(StudentService.class);
        service.createStudent();
        service.findAll().forEach(System.out::println);

        System.out.println("Find Student By First Name And Last Name");
        System.out.println(service.findStudentByFirstNameAndLastName("John","Doe"));

        System.out.println("Find Student By First Name And Last Name Custom Repo");
        System.out.println(service.customRepo("John","Doe"));
    }
}