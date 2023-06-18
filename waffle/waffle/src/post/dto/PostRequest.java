package com.example.waffle.Post.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostRequest {
    private int userId;
    private String title;
    private String cost;
    private String content;
}