package com.example.spring_day6_practice.service;

import com.example.spring_day6_practice.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    Optional<User> findUserById(Long id);
    Optional<User> findUserByUsername(String username);

//    명세 상 존재하지 않아서 일단 기본 구현 후, 추가기능으로
//    User updateUser(Long id, User updatedUser);
//    void deleteUser(Long id);
}
