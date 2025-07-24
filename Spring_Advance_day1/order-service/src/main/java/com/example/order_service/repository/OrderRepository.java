package com.example.order_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.order_service.domain.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
