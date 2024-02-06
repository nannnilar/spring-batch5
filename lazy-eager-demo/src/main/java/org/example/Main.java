package org.example;

import org.example.beans.SpringBean1;
import org.example.beans.SpringBean2;
import org.example.beans.SpringBean6;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.AnnotationConfigurationException;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();
        /*SpringBean1 springBean1 = context.getBean(SpringBean1.class);
        SpringBean1 springBean2 = context.getBean(SpringBean1.class);
        SpringBean1 springBean3 = context.getBean(SpringBean1.class);*/

//        SpringBean2 springBean4 = context.getBean(SpringBean2.class);
//        SpringBean2 springBean5 = context.getBean(SpringBean2.class);

        /*boolean test1 = springBean4 == springBean5;
        System.out.println(test1);

        System.out.println(springBean4);
        System.out.println(springBean5);*/

        /*boolean test = springBean1.equals(springBean2);
        System.out.println("test: " +test);

        System.out.println(springBean1);
        System.out.println(springBean2);
        System.out.println(springBean3);*/

        SpringBean6 springBean6 = context.getBean(SpringBean6.class);
        springBean6.print();
    }
}