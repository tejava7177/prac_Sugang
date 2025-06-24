package com.cloudtone.sugang_backend.service;

import com.cloudtone.sugang_backend.domain.User;
import com.cloudtone.sugang_backend.dto.AddUserRequest;
import com.cloudtone.sugang_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    // 보안 구성과 관련된 부분 제거 또는 주석 처리
    // private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest dto) {
        return userRepository.save(User.builder()
                .studentNumber(dto.getStudentNumber())
                // .password(bCryptPasswordEncoder.encode(dto.getPassword())) // 암호화 제거
                .password(dto.getPassword()) // 평문 저장 (보안 기능 구현 전까지 임시)
                .name(dto.getName())
                .build()).getId();
    }

    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("옳지 않은 사용자입니다."));
    }
}