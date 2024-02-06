package com.example.backend.dto;

public record SignupDto(
        String firstName,
        String lastName,
        String login,
        char[] password
) {
}
