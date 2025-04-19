package com.example.projetofinal.category.rest;

import jakarta.validation.constraints.NotBlank;

public record CategoryForm(
        @NotBlank
        String name
) {
}
