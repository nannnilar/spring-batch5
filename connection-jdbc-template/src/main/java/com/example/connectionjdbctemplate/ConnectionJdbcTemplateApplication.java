package com.example.connectionjdbctemplate;

import com.example.connectionjdbctemplate.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class ConnectionJdbcTemplateApplication implements CommandLineRunner {
    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(ConnectionJdbcTemplateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        employeeService.printWithoutTransaction();
        employeeService.printWithTransaction();
    }
}
