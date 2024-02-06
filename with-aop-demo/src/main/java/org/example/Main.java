package org.example;

import org.example.withoutaop.action.ComplexAction;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

        ComplexAction complexAction = context.getBean(ComplexAction.class);
        complexAction.doAction();
    }
}