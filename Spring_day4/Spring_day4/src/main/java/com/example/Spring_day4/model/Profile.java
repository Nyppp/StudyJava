package com.example.Spring_day4.model;

public class Profile {
    private String name;
    private int age;
    private boolean active;

    // 기본 생성자
    public Profile() {
    }

    // 전체 필드를 초기화하는 생성자
    public Profile(String name, int age, boolean active) {
        this.name = name;
        this.age = age;
        this.active = active;
    }

    // name Getter/Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // age Getter/Setter
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // active Getter/Setter
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    // (선택) 객체 상태 확인을 위한 toString()
    @Override
    public String toString() {
        return "Profile{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", active=" + active +
                '}';
    }
}

