package com.example.waffle.src.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private int userId;
    private String name;
    private String phone;
    private String email;
}
