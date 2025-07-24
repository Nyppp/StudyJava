package com.example.order_service.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import java.util.*;

@Entity
public class Order {
    @GeneratedValue
    private Long id;
    private Customer customer;
    private List<OrderItem> items = new ArrayList<>();
    private OrderStatus status;

    public Order() {
    }

    public Order(Customer customer, List<OrderItem> items, OrderStatus status) {
        this.customer = customer;
        this.items = items;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public int calculateTotalAmount() {
        if(items.isEmpty()){
            return 0;
        }

        int total = 0;
        for (OrderItem item : items){
            total += (int)item.getProduct().getPrice() * item.getAmount();
        }

        if(this.customer.isVip()){
            total = (int)(total * 0.9);
        }
        return total;
    }
}
