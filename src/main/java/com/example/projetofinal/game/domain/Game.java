package com.example.projetofinal.game.domain;

import com.example.projetofinal.game.rest.GameForm;
import jakarta.persistence.*;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nome;
    @Column(columnDefinition = "LONGTEXT")
    private String descricao;
    @Lob
    private String imagem;
    private String origemJogo;
    private String categoria;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "link_id")
    private Link link;

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public Game(GameForm form, Link link) {
        this.nome = form.nome();
        this.descricao = form.descricao();
        this.imagem = form.imagem();
        this.categoria = form.categoria();
        this.origemJogo = form.origemJogo();
        this.link = link;
    }

    public Game() {}

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getOrigemJogo() {
        return origemJogo;
    }
}
