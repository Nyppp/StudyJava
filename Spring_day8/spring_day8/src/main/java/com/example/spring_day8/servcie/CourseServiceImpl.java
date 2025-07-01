package com.example.spring_day8.servcie;

import com.example.spring_day8.model.Course;
import com.example.spring_day8.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    CourseRepository courseRepository;

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> findCourseById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public Page<Course> findAllCoursesWithPage(Pageable pageable) {
        List<Course> allCourses = findAllCourses();

        allCourses.sort((p1, p2) -> p2.getCreatedAt().compareTo(p1.getCreatedAt()));

        int start = (int)pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), allCourses.size());

        List<Course> pageContent = start >= allCourses.size()?
                new ArrayList<>() : allCourses.subList(start, end);

        return new PageImpl<>(pageContent, pageable, allCourses.size());
    }

    @Override
    public Page<Course> findByTitleAndCategoryContaining(String keyword, String category, Pageable pageable) {
        List<Course> allCourses = new ArrayList<>();

        for (Course course : findAllCourses()){
            if(!keyword.isEmpty() && !course.getTitle().contains(keyword)){
                continue;
            }

            if(!category.isEmpty() && !course.getCategory().equals(category)){
                continue;
            }

            allCourses.add(course);
        }

        allCourses.sort((p1, p2) -> p2.getCreatedAt().compareTo(p1.getCreatedAt()));

        int start = (int)pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), allCourses.size());

        List<Course> pageContent = start >= allCourses.size()?
                new ArrayList<>() : allCourses.subList(start, end);

        return new PageImpl<>(pageContent, pageable, allCourses.size());
    }
}
