package com.example.defaultrollbackpolicy;

import com.example.defaultrollbackpolicy.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DefaultRollbackPolicyApplication implements CommandLineRunner {
    @Autowired
    private PersonService personService;

    public DefaultRollbackPolicyApplication(PersonService personService) {
        this.personService = personService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DefaultRollbackPolicyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            personService.create5PersonsWithoutTransaction();
        }catch (Exception e){
            System.out.println("Error Caught!!");
        }
        System.out.println("Find All Persons::");
        personService.findAllPersons().forEach(System.out::println);
        personService.removeAll();
        System.out.println();

        try {
            personService.create5PersonsWithTransaction();
        }catch (Exception e){
            System.out.println("Error Caught in Transaction Method!");
        }
        System.out.println("Find All Persons:");
        personService.findAllPersons().forEach(System.out::println);
        personService.removeAll();
    }
}
