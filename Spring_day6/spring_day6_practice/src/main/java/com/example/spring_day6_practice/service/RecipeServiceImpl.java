package com.example.spring_day6_practice.service;

import com.example.spring_day6_practice.model.Recipe;
import com.example.spring_day6_practice.model.Tag;
import com.example.spring_day6_practice.model.User;
import com.example.spring_day6_practice.repository.CommentRepository;
import com.example.spring_day6_practice.repository.RecipeRepository;
import com.example.spring_day6_practice.repository.TagRepository;
import com.example.spring_day6_practice.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Transactional
public class RecipeServiceImpl implements RecipeService{

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private TagService tagService;

    @Override
    public Recipe createRecipe(String title, String content, String tags, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("존재하지 않는 사용자입니다."));

        String[] tagSplits = tags.split(",");
        Set<Tag> tagSet = new HashSet<>();

        for (String tagName : tagSplits) {
            tagSet.add(tagService.findTagByTagName(tagName));
        }

        return recipeRepository.save(new Recipe(title, content, user, tagSet));
    }

    @Override
    public Optional<Recipe> findRecipeById(Long id) {
        return recipeRepository.findById(id);
    }

    @Override
    public List<Recipe> findRecipesByTitle(String title) {
        return recipeRepository.findRecipesByKeyword(title);
    }

    @Override
    public List<Recipe> findRecipesByTag(Tag tag) {
        return recipeRepository.findRecipesByTagName(tag.getName());
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public Page<Recipe> findAll(Pageable pageable) {
        List<Recipe> allRecipes = getAllRecipes();

        allRecipes.sort((p1, p2) -> p2.getCreatedAt().compareTo(p1.getCreatedAt()));

        int start = (int)pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), allRecipes.size());

        List<Recipe> pageContent = start >= allRecipes.size()?
                new ArrayList<>() : allRecipes.subList(start, end);

        return new PageImpl<>(pageContent, pageable, allRecipes.size());
    }

    @Override
    public Page<Recipe> findByTitleContaining(String keyword, Pageable pageable) {
        return null;
    }
}
