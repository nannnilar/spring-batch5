package com.example.jdbctemplatemethods;

import com.example.jdbctemplatemethods.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class JdbcTemplateMethodsApplication implements CommandLineRunner {
    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(JdbcTemplateMethodsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Find All Employee:");
        employeeService.findAllEmployees()
                .forEach(System.out::println);
        System.out.println();
        System.out.println("High Salary Employee:");
        System.out.println(employeeService.findEmployeeByHighSalary());
        System.out.println("Find Employee By Id:");
        System.out.println(employeeService.findEmployeeById(3));
        /*employeeService.createNewEmployee(
                6,"Flora","Kite","flora@gmail.com", Date.valueOf("2023-03-11"),3000);
        employeeService.findAllEmployees().forEach(System.out::println);*/

        /*employeeService.changeEmployeeFirstName("Ella",6);
        System.out.println();
        System.out.println("Updated Employees");
        employeeService.findAllEmployees().forEach(System.out::println);*/
        System.out.println("Deleting Employee");
        employeeService.deleteEmployeeById(1);
        System.out.println("After delete Employee::");
        employeeService.findAllEmployees().forEach(System.out::println);
    }
}
