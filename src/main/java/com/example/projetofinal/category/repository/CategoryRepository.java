package com.example.projetofinal.category.repository;

import com.example.projetofinal.category.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
