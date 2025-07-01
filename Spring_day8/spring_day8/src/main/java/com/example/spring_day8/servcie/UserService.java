package com.example.spring_day8.servcie;

import com.example.spring_day8.model.User;
import com.example.spring_day8.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    Optional<User> findUserByUserName(String username);
    List<User> findAllUsers();
}
