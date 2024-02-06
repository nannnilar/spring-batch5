package com.example.autoconfigclient;

import org.example.file.FileStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AutoConfigClientApplication implements CommandLineRunner {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private FileStore fileStore;

    public static void main(String[] args) {
        SpringApplication.run(AutoConfigClientApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        employeeService.printEmployeeEmails();
        System.out.println(fileStore.printFileProperties());
    }
}
