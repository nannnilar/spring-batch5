package com.example.springsecuritymaster.fiter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class CustomRequestParamFilter extends OncePerRequestFilter {

    private Logger logger = LoggerFactory.getLogger(CustomRequestParamFilter.class.getName());

    private static final String SECRECT_CODE = "secret";
//    localhost:8080/department/departments?x-code=secret
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        SecurityContext context = SecurityContextHolder.getContext();
        String code = request.getParameter("code");
        logger.info("Secret Code ======================" +code);

        if (context != null && SECRECT_CODE.equals(code)) {
            context.setAuthentication(new UsernamePasswordAuthenticationToken(
                    "john","john",
                    List.of(new SimpleGrantedAuthority("ROLE_SUPER_ADMIN"))
            ));
        }
       /* if (context != null && request.getParameter("x-code") != null){
            context.setAuthentication(new AnonymousAuthenticationToken(
                    "x-code","x-code",
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_SUPER_ADMIN"))
            ));
        }*/
        filterChain.doFilter(request, response);
    }
}
