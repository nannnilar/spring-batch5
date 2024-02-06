package com.example.demodatasourceboot;

import com.example.demodatasourceboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoDatasourceBootApplication {
    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(DemoDatasourceBootApplication.class, args);
    }
    @Bean
    public ApplicationRunner runner(){
        return r ->{
            employeeService.listEmail()
                    .forEach(System.out::println);
        };
    }

}
