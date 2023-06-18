package com.example.waffle.src.user;

import com.example.waffle.src.user.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 회원 가입
    @PostMapping("/sign-up")
    public PostUserRes createUser(@RequestBody PostUserReq postUserReq) {
        try {
            return userService.createUser(postUserReq);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 로그인
    @PostMapping("/log-in")
    public PostLoginRes logIn(@RequestBody PostLoginReq postLoginReq) {
        try {
            return userService.logIn(postLoginReq);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // user 전체 조회
    @GetMapping("")
    public List<GetUserRes> getUsers() {
        try {
            return userService.getUsers();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // userId로 정보 조회 API
    @GetMapping("/{userId}")
    public GetUserRes getUser(@PathVariable("userId") int userId) {
        try {
            return userService.getUser(userId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // user name 수정
    @PatchMapping("/{userId}")
    public String modifyUser(@PathVariable("userId") int userId, @RequestBody User user) {
        try {
            userService.modifyUser(new PatchUserReq(userId, user.getName()));
            return "회원 정보가 수정되었습니다.";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}