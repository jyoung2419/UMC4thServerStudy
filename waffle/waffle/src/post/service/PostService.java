package com.example.waffle.src.post.service;

import com.example.waffle.src.post.dto.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PostService {
    private final PostDao postDao;

    @Autowired
    public PostService(PostDao postDao) {this.postDao = postDao; }

    @Transactional
    // 유저 아이디로 post 조회
    public PostResponse getPost(int userId) throws Exception {
        try {
            return postDao.getPost(userId);
        } catch (Exception e) {
            throw new Exception("게시물 정보 조회 실패");
        }
    }
}
