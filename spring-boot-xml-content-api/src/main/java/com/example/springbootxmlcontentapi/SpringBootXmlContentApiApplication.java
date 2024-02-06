package com.example.springbootxmlcontentapi;

import com.example.springbootxmlcontentapi.dao.EmployeeDao;
import com.example.springbootxmlcontentapi.enity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringBootXmlContentApiApplication {
    private final EmployeeDao employeeDao;
    @Bean @Transactional
    public ApplicationRunner runner(){
        return  r -> {
            List.of(
                    new Employee("John","Doe","john@gmail.com",2000),
                    new Employee("John","William","william@gmail.com",3000),
                    new Employee("Thomas","Hardy","thomas@gmail.com",2500),
                    new Employee("Qazi","Darlsan","qazi@gmail.com",4000),
                    new Employee("Flora","Kite","flora@gmail.com",3500)
            ).forEach(this.employeeDao::save);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootXmlContentApiApplication.class, args);
    }

}
