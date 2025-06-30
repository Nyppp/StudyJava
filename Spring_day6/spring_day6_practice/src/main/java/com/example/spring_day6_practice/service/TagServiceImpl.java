package com.example.spring_day6_practice.service;

import com.example.spring_day6_practice.model.Tag;
import com.example.spring_day6_practice.repository.TagRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TagServiceImpl implements TagService{
    @Autowired
    private TagRepository tagRepository;


    @Override
    public Tag findTagByTagName(String name) {
        return tagRepository.findTagByTagName(name).orElseGet(()->{return createTag(name);});
    }

    @Override
    public Optional<Tag> findTagById(Long id) {
        return tagRepository.findById(id);
    }

    @Override
    public Tag createTag(String name) {
        return tagRepository.save(new Tag(name));
    }

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }
}
