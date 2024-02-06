package org.example;

import org.example.bean.Address;
import org.example.bean.Student;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.management.MBeanServerFactory;

public class Main {
    public static void main(String[] args) {

        /*Student student = new Student();
        student.setAddress(new Address());
        student.setName("John Doe");
        student.setAge(21);
        student.setSchool("ISM");
        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());
        System.out.println("School:" + student.getSchool());*/

        try (AnnotationConfigApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);) {


                Student student = factory.getBean( Student.class);
                student.setName("John Doe");
                student.setAge(21);
                student.setSchool("ISM");
                System.out.println(student.studentInfo());

                System.out.println("Name: " + student.getName());
                System.out.println("Age: " + student.getAge());
                System.out.println("School: " + student.getSchool());

            }
        }
    }
