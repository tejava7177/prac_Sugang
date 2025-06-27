package com.cloudtone.sugang_backend.dto;

import com.cloudtone.sugang_backend.domain.Subject;
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

    public Subject toEntity(){
        return Subject.builder()
                .subjectName(subjectName)
                .subjectCode(subjectCode)
                .professor(professor)
                .grade(grade)
                .build();
    }
}