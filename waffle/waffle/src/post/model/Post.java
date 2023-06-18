package com.example.waffle.src.post.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Post {
    private int userId;
    private String title;
    private String cost;
    private String content;
}