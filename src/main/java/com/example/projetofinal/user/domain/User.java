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

    public User(SignUpForm form) {
        this.username = form.username();
        this.password = form.password();
        this.name = form.name();
    }

    public User() {}

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
