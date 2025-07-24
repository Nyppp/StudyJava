package com.example.order_service.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

@Entity
public class Product {
    @GeneratedValue
    private Long id;
    private String productName;
    private double price;

    public Product() {
    }

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
