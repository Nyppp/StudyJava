package com.example.Spring_day4.model;

public class Member {
    private String name;
    private String email;

    // Constructor
    public Member() {
    }

    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getter/Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}