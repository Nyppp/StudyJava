package com.example.order_service.domain;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class OrderTest {

    @Test
    @DisplayName("주문 생성 시 총액을 계산한다")
    void calculateTotalAmount() {
        Product product1 = new Product("자전거", 50000);
        Product product2 = new Product("선풍기", 3000);

        OrderItem item1 = new OrderItem(product1, 2);
        OrderItem item2 = new OrderItem(product2, 1);

        List<OrderItem> list = List.of(item1, item2);

        Order order = new Order();

        Customer customer = new Customer("", List.of(order), false);
        order.setItems(list);
        order.setCustomer(customer);

        int expectPrice = (50000 * 2) + 3000;
        assertThat(order.calculateTotalAmount()).isEqualTo(expectPrice);
    }

    @Test
    @DisplayName("VIP 고객은 10% 할인을 받는다")
    void vipDiscount() {
        Product product1 = new Product("자전거", 50000);
        Product product2 = new Product("선풍기", 3000);

        OrderItem item1 = new OrderItem(product1, 2);
        OrderItem item2 = new OrderItem(product2, 1);

        List<OrderItem> list = List.of(item1, item2);

        Order order = new Order();

        Customer customer = new Customer("", List.of(order), true);
        order.setItems(list);
        order.setCustomer(customer);

        int expectPrice = (int)(((50000 * 2) + 3000) * 0.9);
        assertThat(order.calculateTotalAmount()).isEqualTo(expectPrice);
    }
}
