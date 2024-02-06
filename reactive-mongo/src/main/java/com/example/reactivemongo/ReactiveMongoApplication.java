package com.example.reactivemongo;

import com.example.reactivemongo.dto.ProductDto;
import com.example.reactivemongo.repository.ProductRepository;
import com.example.reactivemongo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RequiredArgsConstructor
public class ReactiveMongoApplication {

    private final ProductService productService;
    @Bean
    @Profile("test")
    public ApplicationRunner runner(){
        return r->{
            ProductDto p1 = new ProductDto("iphone-15",1500);
            ProductDto p2 = new ProductDto("camera",1000);
            ProductDto p3 = new ProductDto("shirt",100);

            Flux.just(p1,p2,p3)
                    .flatMap(p -> productService.insertProduct(Mono.just(p)))
                    .subscribe(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ReactiveMongoApplication.class, args);
    }

}
