package com.cloudtone.sugang_backend.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Subject {

    // 과목 고유번호(Primary Key)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 1씩증가
    @Column(name = "subject_id", updatable = false)
    private Long subjectId;

    // 과목명
    @Column(name = "subject_name", nullable = false)
    private String subjectName;

    // 과목 코드
    @Column(name = "subject_code", nullable = false, unique = true)
    private String subjectCode;

    // 담당 교수
    @Column(name = "professor", nullable = true)
    private String professor;

    // 학점
    @Column(name = "grade", nullable = true)
    private Integer grade;

    @Builder
    public Subject(String subjectName, String subjectCode, String professor, Integer grade){
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.professor = professor;
        this.grade = grade;
    }
}