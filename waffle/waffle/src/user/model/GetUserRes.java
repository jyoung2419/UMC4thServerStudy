package com.example.waffle.src.user.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetUserRes {
    private int userId;
    private String name;
    private String nickname;
    private String email;
}
