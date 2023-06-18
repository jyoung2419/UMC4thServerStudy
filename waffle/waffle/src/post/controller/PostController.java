package com.example.waffle.src.post.controller;

import com.example.waffle.src.post.service.PostService;
import com.example.waffle.src.post.dto.PostResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 유저의 post 내용 조회
    @ResponseBody
    @GetMapping("/{userId}")
    public PostResponse getPost(@PathVariable("userId") int userId) {
        try {
            return postService.getPost(userId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
