package com.example.order_service.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import java.util.List;

@Entity
public class Customer {
    @GeneratedValue
    private Long id;
    private String name;
    private List<Order> orders;
    private boolean vip;

    public Customer() {
    }

    public Customer(String name, List<Order> orders, boolean vip) {
        this.name = name;
        this.orders = orders;
        this.vip = vip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }
}
