package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        /*Knight knight = new Knight();
        knight.setQuest(new GreatMatrimonyQuest());
        System.out.println(knight.goQuest());*/

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Knight knight = context.getBean("knight", Knight.class);
//        System.out.println(knight.goQuest());
    }
}
