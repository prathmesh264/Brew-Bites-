package com.example.pro.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipeID;

    private String recipeName;
    
    private String cuisineType;

    
    private String ingredients;

    private Integer preparationTime;

    @Column(columnDefinition = "TEXT")
    private String cookingInstructions;

    private String difficultyLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Image image;

    // Constructors
    public Recipe() {}

    public Recipe(String recipeName, String cuisineType, String ingredients, Integer preparationTime,
                  String cookingInstructions, String difficultyLevel, Image image) {
        this.recipeName = recipeName;
        this.cuisineType = cuisineType;
        this.ingredients = ingredients;
        this.preparationTime = preparationTime;
        this.cookingInstructions = cookingInstructions;
        this.difficultyLevel = difficultyLevel;
        this.image = image;
    }

    // Getters and Setters
    public Long getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(Long recipeID) {
        this.recipeID = recipeID;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public Integer getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(Integer preparationTime) {
        this.preparationTime = preparationTime;
    }

    public String getCookingInstructions() {
        return cookingInstructions;
    }

    public void setCookingInstructions(String cookingInstructions) {
        this.cookingInstructions = cookingInstructions;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}