package com.example.pro.Controller;

import com.example.pro.Entity.Image;
import com.example.pro.Entity.Recipe;
import com.example.pro.Service.ImageService;
import com.example.pro.Service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000") // Adjust to your frontend's origin
@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;
    
    @Autowired
    private ImageService imageService;

    // Add new recipe
    @PostMapping("/add")
    public ResponseEntity<String> addRecipe(@RequestParam String recipeName,
                                             @RequestParam String cuisineType,
                                             @RequestParam String ingredients,
                                             @RequestParam Integer preparationTime,
                                             @RequestParam String cookingInstructions,
                                             @RequestParam String difficultyLevel,
                                             @RequestParam Long image_Id) {
        try {
            Recipe savedRecipe = recipeService.saveRecipe(recipeName, cuisineType, ingredients, preparationTime,
                                                          cookingInstructions, difficultyLevel, image_Id);
            return ResponseEntity.ok("Recipe added successfully. ID: " + savedRecipe.getRecipeID());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Recipe addition failed: " + e.getMessage());
        }
    }

    // Retrieve all recipes
    @GetMapping("/")
    public ResponseEntity<Iterable<Recipe>> getAllRecipes() {
        Iterable<Recipe> recipes = recipeService.getAllRecipes();
        return ResponseEntity.ok(recipes);
    }

    // Retrieve recipe by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable Long id) {
        Optional<Recipe> recipeOptional = recipeService.getRecipe(id);
        if (recipeOptional.isPresent()) {
            return ResponseEntity.ok(recipeOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    
}