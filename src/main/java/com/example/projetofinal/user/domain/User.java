package com.example.projetofinal.user.domain;

import com.example.projetofinal.user.rest.SignUpForm;
import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    // 👇 Novo campo
    @Column(nullable = false)
    private String role = "user"; // valor padrão

    public User(SignUpForm form) {
        this.username = form.username();
        this.password = form.password();
        this.name = form.name();
        this.role = "user"; // 👈 padrão para novos cadastros
    }

    public User() {}

    public Long getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getName() { return name; }
    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }
}