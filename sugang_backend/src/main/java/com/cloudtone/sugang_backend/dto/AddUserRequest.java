package com.cloudtone.sugang_backend.dto;

import com.cloudtone.sugang_backend.domain.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserRequest { // 학생 정보를 담고 있는 객체
    private String studentNumber;
    private String password;
    private String name;

    public User toEntity(){
        return User.builder()
                .studentNumber(studentNumber)
                .password(password)
                .name(name)
                .build();
    }
}
