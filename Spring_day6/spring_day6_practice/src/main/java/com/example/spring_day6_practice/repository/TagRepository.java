package com.example.spring_day6_practice.repository;

import com.example.spring_day6_practice.model.Recipe;
import com.example.spring_day6_practice.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {
    @Query("SELECT o FROM Tag o WHERE o.name = :keyword")
    Optional<Tag> findTagByTagName(@Param("keyword") String keyword);
}
