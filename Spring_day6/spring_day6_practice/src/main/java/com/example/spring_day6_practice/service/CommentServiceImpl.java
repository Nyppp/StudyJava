package com.example.spring_day6_practice.service;

import com.example.spring_day6_practice.model.Comment;
import com.example.spring_day6_practice.repository.CommentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getAllCommentsByRecipeId(Long recipeId) {
        return commentRepository.findCommentsByRecipeId(recipeId);
    }
}
