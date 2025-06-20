/*
package com.cloudtone.sugang_backend.service;

import com.cloudtone.sugang_backend.domain.User;
import com.cloudtone.sugang_backend.dto.AddUserRequest;
import com.cloudtone.sugang_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest dto) {
        return userRepository.save(User.builder()
                .studentNumber(dto.getStudentNumber())
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .name(dto.getName())
                .build()).getId();
    }

    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("옳지 않은 사용자입니다."));
    }

}
*/
