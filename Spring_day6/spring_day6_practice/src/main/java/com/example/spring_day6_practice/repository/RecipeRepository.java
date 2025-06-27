package com.example.spring_day6_practice.repository;

import com.example.spring_day6_practice.model.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    @Query("SELECT o FROM Recipe o WHERE o.title = :keyword")
    List<Recipe> findRecipesByKeyword(@Param("keyword") String keyword);

    @Query("SELECT o FROM Recipe o JOIN o.tags t WHERE t.name = :tagName")
    List<Recipe> findRecipesByTagName(@Param("tagName") String tagName);

    Page<Recipe> findAll(Pageable pageable);
    Page<Recipe> findByTitleContaining(String keyword, Pageable pageable);
}
