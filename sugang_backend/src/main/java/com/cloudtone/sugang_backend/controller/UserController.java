package com.cloudtone.sugang_backend.controller;

import com.cloudtone.sugang_backend.dto.AddUserRequest;
import com.cloudtone.sugang_backend.domain.User;
import com.cloudtone.sugang_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // 회원가입 (POST /api/users)
    @PostMapping
    public Long register(@RequestBody AddUserRequest request) {
        return userService.save(request);
    }

    //회원 단건 조회 (GET /api/users/{id})
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }
}