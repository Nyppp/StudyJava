package com.example.spring_day8.repository;

import com.example.spring_day8.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
