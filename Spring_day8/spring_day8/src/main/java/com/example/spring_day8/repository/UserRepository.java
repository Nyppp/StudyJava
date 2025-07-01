package com.example.spring_day8.repository;

import com.example.spring_day8.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT o FROM User o WHERE o.username = :userName")
    Optional<User> findUserByUsername(@Param("userName") String userName);
}
