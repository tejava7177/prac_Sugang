package com.cloudtone.sugang_backend.repository;

import com.cloudtone.sugang_backend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // 학번으로 사용자 조회
    Optional<User> findByStudentNumber(String studentNumber);
}
