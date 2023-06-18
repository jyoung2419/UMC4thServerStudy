package com.example.waffle.src.post.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class PostResponse {
    private int userId;
    private String title;
    private String cost;
    private String content;
}