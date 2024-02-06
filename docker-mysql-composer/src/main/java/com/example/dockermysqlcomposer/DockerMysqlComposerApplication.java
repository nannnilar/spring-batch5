package com.example.dockermysqlcomposer;

import com.example.dockermysqlcomposer.dao.EmployeeDao;
import com.example.dockermysqlcomposer.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class DockerMysqlComposerApplication {
    private final EmployeeDao employeeDao;
//    @Bean
    public ApplicationRunner applicationRunner(){
        return  r -> {
            List.of(
                 new Employee("John","Doe",2000,"john@gmail.com") ,
                 new Employee("John","William",2500,"william@gmail.com")
            ).forEach(employeeDao::save);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(DockerMysqlComposerApplication.class, args);
    }

}
