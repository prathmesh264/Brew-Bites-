package com.example.pro.Service;

import com.example.pro.Entity.Image;
import com.example.pro.Entity.Recipe;
import com.example.pro.Repo.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;
    
   
    @Autowired
    private ImageService imageService;

    // Save Recipe
    public Recipe saveRecipe(String recipeName, String cuisineType, String ingredients, Integer preparationTime,
                              String cookingInstructions, String difficultyLevel, Long imageId) {
        Image image = imageService.getImageById(imageId).orElse(null);
        Recipe recipe = new Recipe(recipeName, cuisineType, ingredients, preparationTime, cookingInstructions, difficultyLevel, image);
        return recipeRepository.save(recipe);
    }

    // Retrieve Recipe by ID
    public Optional<Recipe> getRecipe(Long id) {
        return recipeRepository.findById(id);
    }

    // Retrieve all recipes
    public Iterable<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }
}
