package com.jdc.token.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class TokenProvider {

    public String generate(Authentication authentication) {
        if (null != authentication && authentication.isAuthenticated()){
            return "%s, %s ".formatted(authentication.getName(),
                    authentication.getAuthorities()
                            .stream().map(a -> a.getAuthority()).collect(Collectors.joining(",")));
        }
        return null;
    }
    public Authentication parse(String token){
        if (StringUtils.hasLength(token)){
            var array = token.split(",");
            if (array.length > 1){
                var username = array[0];
                var authorities = Arrays.stream(array).skip(1)
                        .map(auth -> new SimpleGrantedAuthority(auth)).toList();

                return UsernamePasswordAuthenticationToken.authenticated(username,null,authorities);
            }
        }
        return null;
    }
}
