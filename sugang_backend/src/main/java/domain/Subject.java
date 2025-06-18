package domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

/*
    과목 고유번호 (Primary Key) : 각 과목을 식별하는 유일한 값
    과목명 : 어떤 과목인지 식별하는 기본 정보
    과목 코드(교과목 번호) : 대학 시스템에서 과목을 구분하는 공식 코드 (중복 가능성은 있지만 거의 필수)
    담당 교수 (Foreign Key) : 강의를 맡은 교수를 지정 (필수, 하지만 경우에 따라 NULL 허용 가능)
    학점: 학생과 학교에 모두 중요한 정보
*/

@Entity
@Getter
public class Subject {

    // 과목 고유번호(Primary Key)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 1씩증가
    @Column(name = "subject_id", updatable = false)
    private Long subject_id;

    // 과목명
    @Column(name = "subject_name", nullable = false)
    private String subject_name;

    // 과목 코드
    @Column(name = "subject_code", nullable = false, unique = true)
    private String subject_code;

    // 담당 교수
    @Column(name = "professor_id", nullable = true)
    private String professor_id;

    // 학점
    @Column(name = "grade", nullable = true)
    private Long grade;

    @Builder
    public Subject(String subject_name, String subject_code, String professor_id, Long grade){
        this.subject_name = subject_name;
        this.subject_code = subject_code;
        this.professor_id = professor_id;
        this.grade = grade;
    }

    protected Subject(){}
}
