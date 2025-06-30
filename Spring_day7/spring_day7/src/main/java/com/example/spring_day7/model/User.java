package com.example.spring_day7.model;

import lombok.*;


//lombok 라이브러리 사용해 getter, setter, 생성자 어노테이션으로 대체 가능
@Getter
@Setter
@NoArgsConstructor
public class User {
    private String name;
    private String password;
    private String auth;
}
