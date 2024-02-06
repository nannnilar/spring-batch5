package com.example.demoprofile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class DemoProfileApplication {
    @Value("${app.name}")
    private String appName;
    @Bean
    public CommandLineRunner runner() {
        return r ->{
//            String[] strings = new String[2147483647];
//            System.out.println(Integer.MAX_VALUE);
            System.out.println("AppName:" +appName);
        };
    }

    public static void main(String[] args) {

        SpringApplication.run(DemoProfileApplication.class, args);
    }

}
