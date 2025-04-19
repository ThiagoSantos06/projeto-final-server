package com.example.projetofinal.category.domain;

import com.example.projetofinal.category.rest.CategoryForm;
import jakarta.persistence.*;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    public Category(CategoryForm form) {
        this.name = form.name();
    }

    public Category() {}

    public String getName() {
        return name;
    }

}
