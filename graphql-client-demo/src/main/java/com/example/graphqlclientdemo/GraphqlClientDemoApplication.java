package com.example.graphqlclientdemo;

import com.example.graphqlclientdemo.model.Country;
import com.example.graphqlclientdemo.respository.CountryRepository;
import com.example.graphqlclientdemo.service.CountryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

import java.util.List;

@SpringBootApplication
public class GraphqlClientDemoApplication {
    @Bean
    public CommandLineRunner commandLineRunner(CountryService countryService , CountryRepository countryRepository){
        return args -> {
            Mono<List<Country>> countries = countryService.getCountries();
            countries.subscribe(data -> {
               countryRepository.saveAll(data);
            });
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(GraphqlClientDemoApplication.class, args);
    }

}
