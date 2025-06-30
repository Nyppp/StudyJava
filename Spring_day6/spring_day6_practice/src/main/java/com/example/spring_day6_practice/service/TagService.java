package com.example.spring_day6_practice.service;

import com.example.spring_day6_practice.model.Tag;

import java.util.List;
import java.util.Optional;

public interface TagService {
    Tag findTagByTagName(String name);
    Tag createTag(String name);
    Optional<Tag> findTagById(Long id);
    List<Tag> findAll();
}
