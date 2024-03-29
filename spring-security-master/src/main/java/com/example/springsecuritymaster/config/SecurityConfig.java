package com.example.springsecuritymaster.config;

import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService(){
        var uds = new InMemoryUserDetailsManager();

        var john = User.withUsername("join").password("john").roles("SUPER_ADMIN").build();
        var emma = User.withUsername("emma").password("emma").roles("EMPLOYEE_ADMIN").build();
        var william = User.withUsername("william").password("william").roles("DEPARTMENT_PAGE_VIEW",
               "DEPARTMENT_READ", "DEPARTMENT_CREATE").build();
        var lucas = User.withUsername("lucas").password("lucas").roles("CUSTOMER_PAGE_VIEW", "CUSTOMER_READ").build();
        var tom = User.withUsername("tom").password("tom").roles().build();

        uds.createUser(john);
        uds.createUser(emma);
        uds.createUser(william);
        uds.createUser(lucas);
        uds.createUser(tom);

        return uds;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        http.formLogin(c -> c.loginPage("/login").failureUrl("/login-error").permitAll())
                .logout(c -> c.logoutUrl("/logout").logoutSuccessUrl("/login").permitAll())
                .authorizeHttpRequests(c -> c.requestMatchers("/bootstrap/**","/","/home").permitAll()
                        .requestMatchers("/employee/**").hasAnyRole("SUPER_ADMIN","EMPLOYEE_ADMIN")
                        .anyRequest().authenticated());


        return http.build();
    }
}













