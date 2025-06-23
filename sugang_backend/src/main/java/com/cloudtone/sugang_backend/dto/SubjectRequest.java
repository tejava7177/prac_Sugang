package com.cloudtone.sugang_backend.dto;

import com.cloudtone.sugang_backend.domain.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor  // 기본 생성자 추가
@AllArgsConstructor // 모든 필드 값을 파라미터 값으로 받음
public class SubjectRequest {
    private String subjectName;
    private String subjectCode;
    private String professor;
    private Integer grade;

    // Article 엔티티 생성
    public Subject toEntity(){
        return Subject.builder()
                .subjectName(subjectName)
                .subjectCode(subjectCode)
                .professor(professor)
                .grade(grade)
                .build();
    }
}