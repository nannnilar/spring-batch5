package com.example.securityfilterdemo.config;

import com.example.securityfilterdemo.filters.AuthenticationLoggingFilter;
import com.example.securityfilterdemo.filters.RequestValidationFilter;
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
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService(){
        var uds = new InMemoryUserDetailsManager();
        var user1 = User.withUsername("john").password("12345").authorities("read").build();
        uds.createUser(user1);
        return uds;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.httpBasic(Customizer.withDefaults());
        http.addFilterBefore(new RequestValidationFilter(),
                BasicAuthenticationFilter.class).addFilterAfter(new AuthenticationLoggingFilter(),
                BasicAuthenticationFilter.class);
        http.authorizeHttpRequests(c -> c.anyRequest().authenticated());

        return http.build();
    }
}
