package com.example.springsecuritymaster.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {
        http.formLogin(c ->
                c.loginPage("/login")
                        .failureUrl("/login-error")
                        .permitAll()
        ).logout(c -> c.logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .permitAll())
                .authorizeHttpRequests(c -> c.requestMatchers("/bootstrap/**","/","/home","/account/**")
                        .permitAll()
                        .requestMatchers("/employee/**")
                        .hasAnyRole("SUPER_ADMIN","EMPLOYEE_ADMIN")
                        .requestMatchers("/customer/list-customers").hasAnyRole("CUSTOMER_PAGE_VIEW","CUSTOMER_READ","SUPER_ADMIN")
                        .requestMatchers("/customer/**").hasRole("SUPER_ADMIN")
                        .requestMatchers("/department/departments/create","/department/departments","/department/departments/save")
                        .hasAnyRole("SUPER_ADMIN","DEPARTMENT_PAGE_VIEW","DEPARTMENT_READ","DEPARTMENT_CREATE")
                        .requestMatchers("/department/departments/**").hasRole("SUPER_ADMIN")
                        .anyRequest()
                        .authenticated());



        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        var uds = new InMemoryUserDetailsManager();
        var john = User.withUsername("john")
                .password("john")
                .roles("SUPER_ADMIN")
                .build();
        var emma = User.withUsername("emma")
                .password("emma")
                .roles("EMPLOYEE_ADMIN")
                .build();
        var william = User.withUsername("william")
                .password("william")
                .roles("DEPARTMENT_PAGE_VIEW",
                        "DEPARTMENT_READ",
                        "DEPARTMENT_CREATE")
                .build();
        var lucas = User.withUsername("lucas")
                .password("lucas")
                .roles("CUSTOMER_PAGE_VIEW", "CUSTOMER_READ")
                .build();
        var tom = User.withUsername("tom")
                .password("tom")
                .roles()
                .build();
        uds.createUser(john);
        uds.createUser(emma);
        uds.createUser(william);
        uds.createUser(lucas);
        uds.createUser(tom);

        return uds;
    }
}
