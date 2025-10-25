package com.example.projetofinal.game.domain;

import com.example.projetofinal.game.rest.LinkDTO;
import jakarta.persistence.*;

@Entity
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String youtube;
    private String twitch;
    private String gameLink;
    private String other;

    public Link(LinkDTO link) {
        youtube = link.youtube();
        twitch = link.twitch();
        gameLink = link.gameLink();
        other = link.other();
    }

    public Link() {

    }

    public String getYoutube() {
        return youtube;
    }

    public String getTwitch() {
        return twitch;
    }

    public String getGameLink() {
        return gameLink;
    }

    public String getOther() {
        return other;
    }
}
