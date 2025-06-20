package com.cloudtone.sugang_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SubjectResponse {
    private Long subjectId;
    private String subjectName;
    private String subjectCode;
    private String professor;
    private Integer grade;
}