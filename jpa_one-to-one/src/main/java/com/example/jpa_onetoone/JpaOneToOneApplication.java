package com.example.jpa_onetoone;

import com.example.jpa_onetoone.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaOneToOneApplication implements CommandLineRunner {
    private final CustomerService customerService;

    public JpaOneToOneApplication(CustomerService customerService) {
        this.customerService = customerService;
    }

    public static void main(String[] args) {
        SpringApplication.run(JpaOneToOneApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        customerService.createDb();
        JPAUtil.checkData("select * from customer");
        JPAUtil.checkData("select * from address");
    }
}
