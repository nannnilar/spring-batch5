package com.example.dockersample;

import com.example.dockersample.dao.EmployeeDao;
import com.example.dockersample.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class DockerSampleApplication implements CommandLineRunner {
    private final EmployeeDao employeeDao;

    public static void main(String[] args) {
        SpringApplication.run(DockerSampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List.of(
                new Employee("John","Doe","john@gmail.com","01-9876543"),
                new Employee("Thomas","Hardy","thomas@gmail.com","01-876545"),
                new Employee("John","William","william@gmail.com","01-6543234")
        ).forEach(employeeDao::save);
    }
}
