package com.example.waffle.src.user;


import com.example.waffle.src.user.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void SetDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // 회원 가입
    public int createUser(PostUserReq postUserReq) {
        String createUserQuery = "insert into User (email, phone, name) values (?,?,?)";
        Object[] createUserParams = new Object[]{postUserReq.getEmail(), postUserReq.getPhone(), postUserReq.getName()};
        this.jdbcTemplate.update(createUserQuery, createUserParams);
        String lastInsertIdQuery = "select last_insert_id()";

        return this.jdbcTemplate.queryForObject(lastInsertIdQuery, int.class);
    }

    // 로그인(휴대폰번호)
    public User getPhone(PostLoginReq postLoginReq) {
        String getPasswordQuery = "select userId, phone, email, name from User where email = ?";
        String getPasswordParams = postLoginReq.getEmail();

        return this.jdbcTemplate.queryForObject(getPasswordQuery,
                (rs, rowNum) -> new User(
                        rs.getInt("userId"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("name")),
                getPasswordParams
        );
    }

    // 전체 유저 정보 조회
    public List<GetUserRes> getUsers() {
        String getUsersQuery = "select * from User";

        return this.jdbcTemplate.query(getUsersQuery,
                (rs, rowNum) -> new GetUserRes(
                        rs.getInt("userId"),
                        rs.getString("name"),
                        rs.getString("nickname"),
                        rs.getString("email"))
        );
    }

    // 유저 아이디로 정보 조회
    public GetUserRes getUser(int userId) {
        String getUserQuery = "select * from User where userId = ?";

        return this.jdbcTemplate.queryForObject(getUserQuery,
                (rs, rowNum) -> new GetUserRes(
                        rs.getInt("userId"),
                        rs.getString("name"),
                        rs.getString("nickname"),
                        rs.getString("email")),
                userId
        );
    }

    // 회원 정보 수정
    public int modifyUser(PatchUserReq userRequest) {
        String modifyUserQuery = "update User set name = ? where userId = ?";
        Object[] modifyUserParams = new Object[]{userRequest.getName(), userRequest.getUserId()};

        return this.jdbcTemplate.update(modifyUserQuery, modifyUserParams);
    }

    // 이메일 중복 확인
    public int checkEmail(String email) {
        String checkEmailQuery = "select exist(select email from User where email = ?)";
        String checkEmailParams = email;

        return this.jdbcTemplate.queryForObject(checkEmailQuery,
                int.class,
                checkEmailParams);
    }
}
