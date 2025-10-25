package com.example.projetofinal.game.rest;

import jakarta.validation.constraints.NotBlank;

public record GameForm(
        @NotBlank
        String nome,
        @NotBlank
        String descricao,
        @NotBlank
        String imagem,
        @NotBlank
        String categoria,
        @NotBlank
        String origemJogo,
        LinkDTO link
) {
}
