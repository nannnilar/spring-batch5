package com.example.jdbcuserdetailsmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {
    @Bean
   public UserDetailsService userDetailsService(DataSource dataSource){
       var uds = new JdbcUserDetailsManager(dataSource);
       return uds;
   }
   @Bean
   public PasswordEncoder passwordEncoder(){
       return NoOpPasswordEncoder.getInstance();
   }
}
