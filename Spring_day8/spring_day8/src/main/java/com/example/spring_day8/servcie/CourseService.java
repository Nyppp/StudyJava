package com.example.spring_day8.servcie;

import com.example.spring_day8.model.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    Course saveCourse(Course course);
    List<Course> findAllCourses();
    Optional<Course> findCourseById(Long id);

    Page<Course> findAllCoursesWithPage(Pageable pageable);
    Page<Course> findByTitleAndCategoryContaining(String keyword, String category, Pageable pageable);

}
