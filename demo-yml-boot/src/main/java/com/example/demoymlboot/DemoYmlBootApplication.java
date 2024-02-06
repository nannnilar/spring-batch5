package com.example.demoymlboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoYmlBootApplication implements CommandLineRunner {
    @Value("${app.application.name}")
    private String name;
    @Value("${app.application.id}")
    private int id;
    @Value("${app.application.address}")
    private String address;

    public static void main(String[] args) {
        SpringApplication.run(DemoYmlBootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Name:"+name);
        System.out.println("Id:"+id);
        System.out.println("Address:"+address);
    }
}
