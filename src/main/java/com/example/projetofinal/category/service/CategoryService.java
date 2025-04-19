package com.example.projetofinal.category.service;

import com.example.projetofinal.category.domain.Category;
import com.example.projetofinal.category.rest.CategoryForm;
import com.example.projetofinal.category.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void createCategory(CategoryForm form) {
        Category category = new Category(form);
        categoryRepository.save(category);
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}
