package com.example.waffle.src.post.service;

import com.example.waffle.src.post.dto.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class PostDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void SetDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public PostResponse getPost(int userId){
        String getPostQuery = "select * from Post where userId = ? ";
        int getPostParams = userId;

        return this.jdbcTemplate.queryForObject(getPostQuery,
                (rs, rowNum) -> new PostResponse(
                        rs.getInt("postId"),
                        rs.getString("title"),
                        rs.getString("cost"),
                        rs.getString("content")),
                getPostParams
        );
    }
}
