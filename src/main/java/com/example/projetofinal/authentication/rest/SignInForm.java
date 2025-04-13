package com.example.projetofinal.authentication.rest;

import jakarta.validation.constraints.NotBlank;

public record SignInForm(
        @NotBlank
        String username,
        @NotBlank
        String password
) {
}
