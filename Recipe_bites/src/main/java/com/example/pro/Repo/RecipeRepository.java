package com.example.pro.Repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pro.Entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}