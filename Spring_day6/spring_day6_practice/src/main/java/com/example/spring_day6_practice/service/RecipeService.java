package com.example.spring_day6_practice.service;

import com.example.spring_day6_practice.model.Recipe;
import com.example.spring_day6_practice.model.Tag;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface RecipeService {
    Recipe createRecipe(String title, String content, String tags, Long userId);
    Recipe updateRecipe(Long id, Recipe recipe);
    Optional<Recipe> findRecipeById(Long id);
    List<Recipe> findRecipesByTitle(String title);
    List<Recipe> findRecipesByTag(Tag tag);
    List<Recipe> getAllRecipes();

    Page<Recipe> findAll(Pageable pageable);
    Page<Recipe> findByTitleContaining(String keyword, Pageable pageable);

}
