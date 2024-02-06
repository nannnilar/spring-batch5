package com.example.userdetailsservicecustomjpa;

import com.example.userdetailsservicecustomjpa.dao.EmployeeDao;
import com.example.userdetailsservicecustomjpa.entity.Employee;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class UserdetailsServiceCustomJpaApplication {
    private final PasswordEncoder passwordEncoder;
    private final EmployeeDao employeeDao;

    public UserdetailsServiceCustomJpaApplication(PasswordEncoder passwordEncoder, EmployeeDao employeeDao) {
        this.passwordEncoder = passwordEncoder;
        this.employeeDao = employeeDao;
    }
    @Bean @Transactional
    @Profile("test")
    public ApplicationRunner runner(){
        return r -> {
          /*  Employee employee1 = new Employee("john",
                    "john@gmail.com", passwordEncoder.encode("12345"),"read");
            Employee employee2 = new Employee("mary",
                    "mary@gmail.com", passwordEncoder.encode("mary"),"write");*/
            Employee employee1 = new Employee("thaw",
                    "thaw@gmail.com",passwordEncoder.encode("123"),"read");
            Employee employee2 = new Employee("thuza",
                    "thuza@gmail.com",passwordEncoder.encode("123"),"write");
            employeeDao.save(employee1);
            employeeDao.save(employee2);
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(UserdetailsServiceCustomJpaApplication.class, args);
    }

}
