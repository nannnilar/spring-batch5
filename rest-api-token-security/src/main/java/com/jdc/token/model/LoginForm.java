package com.jdc.token.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

public record LoginForm(
        @NotBlank(message = "Enter Login Id.")
        String username,
        @NotBlank(message = "Enter Password")
        String password
) {
    public Authentication authentication() {
        return UsernamePasswordAuthenticationToken.unauthenticated(username,password);
    }
}
