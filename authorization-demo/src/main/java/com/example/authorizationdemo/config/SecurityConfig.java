package com.example.authorizationdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;

@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService(){
        var uds = new InMemoryUserDetailsManager();
        var user1 = User.withUsername("john").password("12345").roles("ADMIN").build();
        var user2 = User.withUsername("mary").password("12345").roles("USER").build();
        var user3 = User.withUsername("thomas").password("12345").roles("MANAGER").build();

        uds.createUser(user1);
        uds.createUser(user2);
        uds.createUser(user3);

        return uds;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
//        http.httpBasic(Customizer.withDefaults());
//        String expression =
//                """
//                hasAnyRole('ADMIN','USER') && !hasRole('MANAGER')
//                """;
//        http.authorizeHttpRequests(c -> c.anyRequest().access(
//                new WebExpressionAuthorizationManager(expression)
//        ));
//
//        return http.build();
//    }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//        http.httpBasic(Customizer.withDefaults());
//        http.authorizeHttpRequests(c -> c.requestMatchers("/hello/greeting/*").hasAnyRole("ADMIN","USER")
//                .requestMatchers("/greetin?/**").hasRole("MANAGER")
//                .anyRequest().permitAll());
//
//        return http.build();
//    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.httpBasic(Customizer.withDefaults());
        http.authorizeHttpRequests(c -> c.requestMatchers(HttpMethod.GET,"/a/**").authenticated()
                .requestMatchers(HttpMethod.POST,"/a").permitAll()
                .anyRequest().denyAll());

        http.csrf(c -> c.disable());

        return http.build();
    }
}
