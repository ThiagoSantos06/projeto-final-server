package com.example.projetofinal.category.rest;

import com.example.projetofinal.category.domain.Category;
import com.example.projetofinal.category.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public void createCategory(@RequestBody @Valid CategoryForm form) {
        categoryService.createCategory(form);
    }

    @GetMapping
    public List<Category> getAllCategories() {
        List<Category> categories = categoryService.getCategories();

        // DEBUG - Verifica se os IDs estão vindo
        System.out.println("=== DEBUG CATEGORY CONTROLLER ===");
        System.out.println("Total de categorias: " + categories.size());

        if (categories.isEmpty()) {
            System.out.println("❌ Nenhuma categoria encontrada!");
        } else {
            categories.forEach(cat -> {
                System.out.println("🔍 Category ID: " + cat.getId() + ", Name: " + cat.getName());

                // Verifica se o ID é null
                if (cat.getId() == null) {
                    System.out.println("⚠️  ATENÇÃO: Category '" + cat.getName() + "' tem ID NULL!");
                }
            });
        }

        return categories;
    }
}