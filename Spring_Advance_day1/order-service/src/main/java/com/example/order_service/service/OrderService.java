package com.example.order_service.service;

import com.example.order_service.domain.*;
import com.example.order_service.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderService(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    // TODO: 생성자

//    public Order createOrder(Long customerId, List<wOrderRequest> requests) {
//        // TODO: 구현
//        return null;
//    }

    private void validateStock(Product product, int quantity) {
        // TODO: 재고 검증
    }

    private void validateMinimumAmount(int totalAmount) {
        // TODO: 최소 금액 검증
    }
}
