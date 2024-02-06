package com.example.statickeyfilter.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class StaticKeyAuthenticationFilter implements Filter {
    @Value("${static.secret.key}")
     private String key;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String authorization = request.getHeader("Authorization");
        if(key.equals(authorization)){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
