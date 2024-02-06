package com.example.platformtransactionmanager;

import com.example.platformtransactionmanager.service.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlatformTransactionManagerApplication implements CommandLineRunner {

    private PersonService personService;
    public PlatformTransactionManagerApplication(PersonService personService) {
        this.personService = personService;
    }

    public static void main(String[] args) {
        SpringApplication.run(PlatformTransactionManagerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            personService.deleteAll();
            personService.createPerson();
            personService.findAllPersons().forEach(System.out::println);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
