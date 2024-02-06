package com.example.reactivemongo.config;

import com.example.reactivemongo.handler.ProductHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@RequiredArgsConstructor
public class RouterConfig {

    private final ProductHandler handler;
    @Bean
    RouterFunction<ServerResponse> routes(){
        RouterFunctions.route()
                .GET()
    }
}
