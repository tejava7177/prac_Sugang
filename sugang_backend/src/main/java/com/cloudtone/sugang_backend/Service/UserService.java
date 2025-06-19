package com.cloudtone.sugang_backend.Service;

import com.cloudtone.sugang_backend.domain.User;
import com.cloudtone.sugang_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    // TODO: UserRepository, save 메서드 등 구현 필요
    //메서드 추가
    public User findById(Long userId){
        return userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
    }
}
