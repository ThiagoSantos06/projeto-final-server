package com.example.projetofinal.game.rest;

import com.example.projetofinal.game.domain.Link;

public record LinkDTO(
        String youtube,
        String twitch,
        String gameLink,
        String other
) {

    public LinkDTO(Link link) {
        this(
                link.getYoutube(),
                link.getTwitch(),
                link.getGameLink(),
                link.getOther()
        );
    }
}
