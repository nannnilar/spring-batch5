package com.example.csrftokenrepository.config;

import com.example.csrftokenrepository.csrf.CustomCsrfTokenRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;

@Configuration
public class SecurityConfig {
//    curl -H "X-IDENTIFIER:12345" http://localhost:8080/hello

    private final CustomCsrfTokenRepository repository;

    public SecurityConfig(CustomCsrfTokenRepository repository) {
        this.repository = repository;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{

        http.csrf(c -> {c.csrfTokenRepository(repository);
                        c.csrfTokenRequestHandler(new CsrfTokenRequestAttributeHandler());
        });
        http.authorizeHttpRequests(c -> c.anyRequest().permitAll());

        return http.build();
    }
}
