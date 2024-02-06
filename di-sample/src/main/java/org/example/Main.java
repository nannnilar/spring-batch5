package org.example;

import org.example.bean.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
       /* Person person = new Person();
        Address address = new Address();
        address.setCity("Ygn");
        person.setAddress(address);
        person.setName("John Doe");
        System.out.println(person.personInfo());*/

        /*ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Person person = context.getBean("person",Person.class);
        System.out.println(person.personInfo());*/

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Person person = context.getBean("person",Person.class);
        System.out.println(person.personInfo());

    }
}
