package com.cloudtone.sugang_backend.repository;

import com.cloudtone.sugang_backend.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Optional<Subject> findBySubjectCode(String subjectCode);
}