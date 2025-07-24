package com.example.order_service.Service;

import com.example.order_service.domain.*;
import com.example.order_service.repository.*;
import com.example.order_service.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    @DisplayName("재고가 충분하면 주문에 성공한다")
    void createOrderWithSufficientStock() {
        // given
        // TODO: Mock 설정

        // when
        // TODO: 주문 생성

        // then
        // TODO: 검증
    }

    @Test
    @DisplayName("재고가 부족하면 예외가 발생한다")
    void insufficientStockThrowsException() {
        // TODO: 재고 부족 시나리오
    }

    @Test
    @DisplayName("최소 주문 금액 미달 시 예외가 발생한다")
    void minimumOrderAmountValidation() {
        // TODO: 10,000원 미만 주문
    }
}
