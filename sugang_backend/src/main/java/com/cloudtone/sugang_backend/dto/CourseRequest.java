package com.cloudtone.sugang_backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseRequest {
    private Long userId;
    private Long subjectId;
}