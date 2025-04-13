package com.example.projetofinal.user.rest;

import jakarta.validation.constraints.NotBlank;

public record SignUpForm(
        @NotBlank
        String username,
        @NotBlank
        String password,
        @NotBlank
        String name
) {
}
