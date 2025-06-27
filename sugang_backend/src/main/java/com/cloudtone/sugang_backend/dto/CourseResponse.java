package com.cloudtone.sugang_backend.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CourseResponse {
    private Long courseId;
    private Long userId;
    private Long subjectId;
    private String subjectName;
    private String professor;
}