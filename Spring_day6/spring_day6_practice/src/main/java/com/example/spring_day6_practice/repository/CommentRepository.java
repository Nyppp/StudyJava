package com.example.spring_day6_practice.repository;

import com.example.spring_day6_practice.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("SELECT o FROM Comment o WHERE o.recipe.id = :recipe_id")
    List<Comment> findCommentsByRecipeId(@Param("recipe_id") Long recipeId);
}
