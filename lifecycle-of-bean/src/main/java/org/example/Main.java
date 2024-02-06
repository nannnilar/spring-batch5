package org.example;

import org.example.bean.SpringBean1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();
        SpringBean1 springBean1 = context.getBean(SpringBean1.class);
        System.out.println(springBean1.sayHello());
    }
}