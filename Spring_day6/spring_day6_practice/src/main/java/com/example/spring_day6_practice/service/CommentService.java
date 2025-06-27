package com.example.spring_day6_practice.service;

import com.example.spring_day6_practice.model.Comment;

import java.util.List;

public interface CommentService {
    Comment saveComment(Comment comment);
    List<Comment> getAllCommentsByRecipeId(Long recipeId);
}
