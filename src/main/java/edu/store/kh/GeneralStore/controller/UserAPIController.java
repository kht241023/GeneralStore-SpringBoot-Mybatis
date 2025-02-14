package edu.store.kh.GeneralStore.controller;


import edu.store.kh.GeneralStore.dto.User;
import edu.store.kh.GeneralStore.service.UserServiceImple;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserAPIController {


    @Autowired
    private UserServiceImple userService;


    // 로그인
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody User user, HttpSession session) {
        User loginUser = userService.loginUser(user.getUserId(), user.getPassword());

        Map<String, Object> response = new HashMap<>();

        if (loginUser != null) {
            session.setAttribute("user", loginUser);
            response.put("status", "success");
            response.put("user", loginUser);
            return ResponseEntity.ok(response); //로그인 성공 시 상태번호 200 제공

        } else {
            response.put("status", "fail");
            response.put("message", "아이디 또는 비밀번호가 올바르지 않습니다.");
            return ResponseEntity.status(401).body(response);
            // 401 : sql 에서 일치하는 값을 찾지 못했을 때 발생하는 에러
        }
    }
    //로그아웃

    // 로그인 상태 확인

    // 특정 유저 정보 조회 -> mypage
}
