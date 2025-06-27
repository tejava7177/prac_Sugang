package com.cloudtone.sugang_backend.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
    과목 고유번호 (Primary Key) : 각 과목을 식별하는 유일한 값
    과목명 : 어떤 과목인지 식별하는 기본 정보
    과목 코드(교과목 번호) : 대학 시스템에서 과목을 구분하는 공식 코드 (중복 가능성은 있지만 거의 필수)
    담당 교수 (Foreign Key) : 강의를 맡은 교수를 지정 (필수, 하지만 경우에 따라 NULL 허용 가능)
    학점: 학생과 학교에 모두 중요한 정보
*/

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Subject {

    // 과목 고유번호(Primary Key)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 1씩증가
    @Column(name = "subjectId", updatable = false)
    private Long subjectId;

    // 과목명
    @Column(name = "subjectName", nullable = false)
    private String subjectName;

    // 과목 코드
    @Column(name = "subjectCode", nullable = false, unique = true)
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