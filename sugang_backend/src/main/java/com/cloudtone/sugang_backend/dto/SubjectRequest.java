package com.cloudtone.sugang_backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectRequest {
    private String subjectName;
    private String subjectCode;
    private String professor;
    private Integer grade;
}