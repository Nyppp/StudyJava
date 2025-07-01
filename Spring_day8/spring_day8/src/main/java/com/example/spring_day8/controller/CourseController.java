package com.example.spring_day8.controller;

import com.example.spring_day8.model.Comment;
import com.example.spring_day8.model.Course;
import com.example.spring_day8.model.Rating;
import com.example.spring_day8.model.User;
import com.example.spring_day8.servcie.CommentService;
import com.example.spring_day8.servcie.CourseService;
import com.example.spring_day8.servcie.RatingService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;

@Controller
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    CourseService courseService;

    @Autowired
    CommentService commentService;

    @Autowired
    RatingService ratingService;

    @GetMapping
    public String showCoursesPage(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "") String keyword,
                                  @RequestParam(defaultValue = "") String category,
                                  Model model,
                                  HttpSession session){
        try {
            Pageable pageable = PageRequest.of(page, 6);
            Page<Course> coursePage;

            coursePage = courseService.findByTitleAndCategoryContaining(keyword, category, pageable);

            model.addAttribute("page", coursePage);
            model.addAttribute("keyword", keyword);
            model.addAttribute("category", category);
            model.addAttribute("user", session.getAttribute("user")); // 로그인 상태 확인용
        } catch (Exception e) {
            // 에러 발생시 빈 페이지 처리
            model.addAttribute("page", null);
            model.addAttribute("keyword", keyword);
            model.addAttribute("category", category);
            model.addAttribute("user", session.getAttribute("user"));
        }
        return "courses";
    }

    @GetMapping("/new")
    public String showCourseForm(Model model,
                                 HttpSession session){
        if(session.getAttribute("user") == null){
            model.addAttribute("error", "강의 등록은 로그인이 필요합니다.");
            return "login";
        }
        model.addAttribute("user", session.getAttribute("user"));
        return "course_form";
    }

    @GetMapping("/{id}")
    public String showCourseDetail(@PathVariable Long id, Model model, HttpSession session){
        Optional<Course> courseOptional = courseService.findCourseById(id);

        if(courseOptional.isEmpty()){
            return "courses";
        }

        model.addAttribute("user", session.getAttribute("user"));
        model.addAttribute("course", courseOptional.get());
        model.addAttribute("rate", ratingService.getAvgRating(courseOptional.get().getId()));
        return "course_detail";
    }

    @PostMapping("/{id}/comments")
    public String addComment(@PathVariable Long id,
                             @RequestParam String content,
                             Model model, HttpSession session){
        if(session.getAttribute("user") == null){
            model.addAttribute("error", "댓글 등록은 로그인이 필요합니다.");
            return "login";
        }

        Course course = courseService.findCourseById(id).get();

        User user = (User)session.getAttribute("user");
        Comment comment = new Comment(content, user, course);
        commentService.saveComment(comment);


        course.getComments().add(comment);
        courseService.saveCourse(course);

        model.addAttribute("course", course);
        model.addAttribute("user", user);
        return "redirect:/courses/"+id;
    }

    @PostMapping("/{id}/like")
    public String addLike(@PathVariable Long id,
                             Model model, HttpSession session){
        if(session.getAttribute("user") == null){
            model.addAttribute("error", "좋아요 주기는 로그인이 필요합니다.");
            return "login";
        }

        Course course = courseService.findCourseById(id).get();

        User user = (User)session.getAttribute("user");
        if(course.getLikedUsers().contains(user)){
            course.getLikedUsers().remove(user);
        }else{
            course.getLikedUsers().add(user);
        }
        courseService.saveCourse(course);

        model.addAttribute("course", course);
        model.addAttribute("user", user);
        return "redirect:/courses/"+id;
    }

    @PostMapping("/{id}/rate")
    public String rateCourse(@PathVariable Long id,
                             @RequestParam Double score,
                             Model model, HttpSession session){
        if(session.getAttribute("user") == null){
            model.addAttribute("error", "별점 주기는 로그인이 필요합니다.");
            return "login";
        }
        Course course = courseService.findCourseById(id).get();
        User user = (User)session.getAttribute("user");

        for (Rating rating : course.getRatings()){
            if(rating.getUserId() == user.getId()){
                rating.setRate(score);
                ratingService.saveRating(rating);

                course.setRate(ratingService.getAvgRating(course.getId()));
                courseService.saveCourse(course);
                return "redirect:/courses/"+id;
            }
        }

        Rating rating = new Rating(score, course.getId(), user.getId());

        ratingService.saveRating(rating);

        course.getRatings().add(rating);
        course.setRate(ratingService.getAvgRating(course.getId()));
        courseService.saveCourse(course);
        return "redirect:/courses/"+id;
    }

    @PostMapping
    public String addNewCourse(@RequestParam String title,
                               @RequestParam String description,
                               @RequestParam String url,
                               @RequestParam String category,
                               Model model, HttpSession session){
        if(session.getAttribute("user") == null){
            model.addAttribute("error", "강의 등록은 로그인이 필요합니다.");
            return "login";
        }

        User user = (User)session.getAttribute("user");
        Course course = new Course(title, description, category, url, user);
        course.setCreatedAt(LocalDateTime.now());
        courseService.saveCourse(course);

        model.addAttribute("user", user);
        return "redirect:/courses/" + course.getId();
    }
}
