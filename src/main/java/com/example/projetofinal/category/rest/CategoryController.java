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
        return categoryService.getCategories();
    }
}
