package com.example.spring_day6_practice.controller;

import com.example.spring_day6_practice.model.Recipe;
import com.example.spring_day6_practice.model.Tag;
import com.example.spring_day6_practice.model.User;
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

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Controller
public class RecipeController {
    @Autowired
    private TagService tagService;
    @Autowired
    private RecipeService recipeService;

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
            model.addAttribute("user", session.getAttribute("user")); // 로그인 상태 확인용
        } catch (Exception e) {
            // 에러 발생시 빈 페이지 처리
            model.addAttribute("page", null);
            model.addAttribute("keyword", keyword);
            model.addAttribute("tag", tag);
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

        recipeService.createRecipe(title, description, tags, user.getId());
        return "redirect:/recipes";
    }
}
