package com.example.Spring_day4.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private Long id;
    private String status;
    private LocalDateTime orderedAt;
    private List<String> items;

    // Constructor
    public Order() {
    }

    public Order(Long id, String status, LocalDateTime orderedAt, List<String> items) {
        this.id = id;
        this.status = status;
        this.orderedAt = orderedAt;
        this.items = items;
    }

    // Getter/Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(LocalDateTime orderedAt) {
        this.orderedAt = orderedAt;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }
}