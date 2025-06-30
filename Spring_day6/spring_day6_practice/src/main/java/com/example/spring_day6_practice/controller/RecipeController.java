package com.example.spring_day6_practice.controller;

import com.example.spring_day6_practice.model.Comment;
import com.example.spring_day6_practice.model.Recipe;
import com.example.spring_day6_practice.model.Tag;
import com.example.spring_day6_practice.model.User;
import com.example.spring_day6_practice.service.CommentService;
import com.example.spring_day6_practice.service.RecipeService;
import com.example.spring_day6_practice.service.TagService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Controller
public class RecipeController {
    @Autowired
    private TagService tagService;
    @Autowired
    private RecipeService recipeService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/recipes")
    public String showRecipePage(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "") String keyword,
                                 @RequestParam(defaultValue = "") String tag,
                                 Model model,
                                 HttpSession session){
        try {
            Pageable pageable = PageRequest.of(page, 4); // 페이지당 4개로 변경
            Page<Recipe> recipePage;

            if (!keyword.isEmpty()) {
                recipePage = recipeService.findByTitleContaining(keyword, pageable);
            } else {
                recipePage = recipeService.findAll(pageable);
            }

            model.addAttribute("page", recipePage);
            model.addAttribute("keyword", keyword);
            model.addAttribute("tag", tag);
            model.addAttribute("tags", tagService.findAll() != null ? tagService.findAll() : Collections.emptyList());
            model.addAttribute("user", session.getAttribute("user")); // 로그인 상태 확인용
        } catch (Exception e) {
            // 에러 발생시 빈 페이지 처리
            model.addAttribute("page", null);
            model.addAttribute("keyword", keyword);
            model.addAttribute("tag", tag);
            model.addAttribute("tags", Collections.emptyList());
            model.addAttribute("user", session.getAttribute("user"));
        }
        return "recipes";
    }

    @GetMapping("/recipes/{id}")
    public String showRecipeDetail(@PathVariable Long id, Model model, HttpSession session){
        Optional<Recipe> recipe = recipeService.findRecipeById(id);

        if(recipe != null){
            model.addAttribute("user", session.getAttribute("user"));
            model.addAttribute("recipe", recipe.get());
            return "recipe_detail";
        }else{
            return "recipes";
        }
    }

    @PostMapping("/recipes/{id}/like")
    public String addLikes(@PathVariable Long id, Model model, HttpSession session){
        Optional<Recipe> recipeOptional = recipeService.findRecipeById(id);
        Recipe recipe = recipeOptional.get();

        if(recipe != null){
            User user = (User)session.getAttribute("user");
            if(recipe.getLikes().contains(user)){
                recipe.getLikes().remove(user);
            }else{
                recipe.getLikes().add(user);
            }

            recipeService.updateRecipe(id, recipe);

            model.addAttribute("user", session.getAttribute("user"));
            model.addAttribute("recipe", recipe);
        }

        return "redirect:/recipes/" + id;
    }

    @PostMapping("/recipes/{id}/comments")
    public String addComments(@PathVariable Long id, @RequestParam String content, Model model, HttpSession session){
        Optional<Recipe> recipeOptional = recipeService.findRecipeById(id);
        Recipe recipe = recipeOptional.get();

        if(recipe != null){
            User user = (User)session.getAttribute("user");
            Comment comment = new Comment(content, user, recipe);

            recipe.getComments().add(comment);

            recipeService.updateRecipe(id, recipe);

            model.addAttribute("user", session.getAttribute("user"));
            model.addAttribute("recipe", recipe);
        }

        return "redirect:/recipes/" + id;
    }


    @GetMapping("/recipes/new")
    public String showRecipeForm(Model model, HttpSession session){
        User user = (User)session.getAttribute("user");
        if(user == null){
            model.addAttribute("error", "레시피 작성은 회원만 가능합니다.");
            return "login";
        }else{
            return "recipe_form";
        }
    }

    @PostMapping("/recipes")
    public String addNewRecipe(@RequestParam String title,
                               @RequestParam String description,
                               @RequestParam String tags,
                               Model model, HttpSession session){
        User user = (User)session.getAttribute("user");
        if(user == null) {
            model.addAttribute("error", "레시피 작성은 회원만 가능합니다.");
            return "login";
        }

        Long id = recipeService.createRecipe(title, description, tags, user.getId()).getId();
        return "redirect:/recipes/" + id;
    }
}
