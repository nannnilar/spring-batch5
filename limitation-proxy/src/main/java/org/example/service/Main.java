package org.example.service;

import org.example.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

        MyStudentService myStudentService = context.getBean(MyStudentService.class);
        myStudentService.goShool();
//        myStudentService.playFootball();
//        myStudentService.takeExam();
    }
}
