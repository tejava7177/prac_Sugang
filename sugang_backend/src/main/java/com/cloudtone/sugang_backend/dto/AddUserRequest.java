package com.cloudtone.sugang_backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserRequest {
    private String studentNumber;
    private String password;
    private String name;
}
