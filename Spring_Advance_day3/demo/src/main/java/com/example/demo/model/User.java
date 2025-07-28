package com.example.demo.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "사용자 정보")
public class User {

    @Schema(description = "사용자 ID", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "사용자 이름", example = "홍길동", required = true)
    private String name;

    @Schema(description = "이메일 주소", example = "hong@example.com", required = true)
    private String email;

    @Schema(description = "나이", example = "25", minimum = "0", maximum = "150")
    private Integer age;

    @Schema(description = "활성 상태", example = "true", defaultValue = "true")
    private Boolean active = true;

    // 기본 생성자
    public User() {
    }

    // 모든 필드를 포함한 생성자
    public User(Long id, String name, String email, Integer age, Boolean active) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.active = active;
    }

    // Getters and Setters
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", active=" + active +
                '}';
    }
}