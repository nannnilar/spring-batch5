package org.example;

import org.example.service.RecordService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerShutdownHook();

        context.getEnvironment().setActiveProfiles("db","test");
        context.register(AppConfig.class);
        context.refresh();

        RecordService recordService = context.getBean(RecordService.class);
        recordService.doAction();
    }
}