package com.cloudtone.sugang_backend.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "subject_id"})
})
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ManyToOne        : 다대일 관계 + 외래키 자동 연결
    // optional = false :  NULL 불가

    /*
    @ManyToOne(optional = false)
    private User user;

    @ManyToOne(optional = false)
    private Subject subject;
    */

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")     // ✅ 이거 추가
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "subject_id")  // ✅ 이거 꼭 추가!
    private Subject subject;

    @Builder
    public Course(User user, Subject subject) {
        this.user = user;
        this.subject = subject;
    }
}


/*
package com.cloudtone.sugang_backend.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "subject_id"})
})
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ManyToOne        : 다대일 관계 + 외래키 자동 연결
    // optional = false :  NULL 불가
    @ManyToOne(optional = false)
    private User user;

    @ManyToOne(optional = false)
    private Subject subject;

    @Builder
    public Course(User user, Subject subject) {
        this.user = user;
        this.subject = subject;
    }
}
 */