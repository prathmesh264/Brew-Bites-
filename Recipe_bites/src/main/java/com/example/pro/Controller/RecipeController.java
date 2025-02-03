package com.example.pro.Controller;


import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.pro.Entity.Recipe;
import com.example.pro.Service.RecipeService;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

	@Autowired
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id) {
        Optional<Recipe> recipeOpt = recipeService.getRecipeById(id);

        if (recipeOpt.isPresent()) {
            Recipe recipe = recipeOpt.get();
            if (recipe.getImage() != null) {
                String base64Image = Base64.getEncoder().encodeToString(recipe.getImage());
                recipe.setImage(base64Image.getBytes()); // Temporarily set the image as a base64 string.
            }
            return ResponseEntity.ok(recipe);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Recipe saveRecipe(@RequestPart("recipe") Recipe recipe, @RequestPart("image") MultipartFile image) throws IOException {
        recipe.setImage(image.getBytes());
        return recipeService.saveRecipe(recipe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
        return ResponseEntity.noContent().build();
    }
    
    
}
