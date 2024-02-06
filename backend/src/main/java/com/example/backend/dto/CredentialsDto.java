package com.example.backend.dto;

public record CredentialsDto(
        String login,
        char[] loginPassword
) {
}
