package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // 기본 CRUD 메서드는 자동으로 제공됨
    // findAll(), findById(), save(), deleteById() 등

    // 필요한 경우 커스텀 쿼리 메서드 추가
    List<User> findByStatus(String status);
    List<User> findByNameContaining(String name);
}