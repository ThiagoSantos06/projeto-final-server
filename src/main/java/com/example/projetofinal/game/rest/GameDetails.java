package com.example.projetofinal.game.rest;

import com.example.projetofinal.game.domain.Game;

public record GameDetails(
        Long id,
        String nome,
        String descricao,
        String imagem,
        String categoria,
        String origemJogo,
        LinkDTO link
) {

    public GameDetails (Game game) {
        this(
                game.getId(),
                game.getNome(),
                game.getDescricao(),
                game.getImagem(),
                game.getCategoria(),
                game.getOrigemJogo(),
                game.getLink() != null ? new LinkDTO(game.getLink()) : null
        );
    }
}
