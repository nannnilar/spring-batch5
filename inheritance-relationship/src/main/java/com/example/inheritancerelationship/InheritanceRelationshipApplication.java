package com.example.inheritancerelationship;

import com.example.inheritancerelationship.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InheritanceRelationshipApplication implements CommandLineRunner {
    private final VetService vetService;

    public InheritanceRelationshipApplication(VetService vetService) {
        this.vetService = vetService;
    }
    public static void main(String[] args) {
        SpringApplication.run(InheritanceRelationshipApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        vetService.createDb();
//        JPAUtil.checkData("select * from vet");
        JPAUtil.checkData("select * from in_house_vet");
        JPAUtil.checkData("select * from ex_house_vet");
    }
}
