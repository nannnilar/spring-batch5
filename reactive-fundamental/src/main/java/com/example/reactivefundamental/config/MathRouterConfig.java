package com.example.reactivefundamental.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;

@Configuration
@RequiredArgsConstructor
public class MathRouterConfig {
    private final  RequestHandler handler;
    @Bean
    public RouterFunction<ServerResponse> mathRouter(){
        return RouterFunctions.route()
                .GET("square/{input}",
                        RequestPredicates.path("*/1?").or(RequestPredicates.path("*/20"))
                        ,handler::squareHandler)
                .GET("square/{input}"
                        ,req -> ServerResponse.badRequest().bodyValue("only 10 - 20"))
                .GET("table/{input}",handler::tableHandler)
                .GET("table/{input}/stream",handler::tableHandlerStream)
                .build();
    }
}
