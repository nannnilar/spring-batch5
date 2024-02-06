package org.example;

import org.example.service.EmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

        EmployeeService employeeService = context.getBean(EmployeeService.class);
//        employeeService.listEmials().forEach(System.out::println);
//        employeeService.findAllEmployee().forEach(System.out::println);

        System.out.println("Average Salary for Employee::"+
                employeeService.avarageByRowCallbackHandler());
        System.out.println("Average Salary for Employee Using ResultSetExtractor::"+
                employeeService.averageResultSetExtractor());
        System.out.println();
        System.out.println("Find Employee Id By Eamil::"+ employeeService.findEmployeeIdByEmail("thomashardy@gmail.com"));
    }


}