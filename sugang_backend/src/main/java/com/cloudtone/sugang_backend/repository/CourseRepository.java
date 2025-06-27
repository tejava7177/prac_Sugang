package com.cloudtone.sugang_backend.repository;

import com.cloudtone.sugang_backend.domain.Course;
import com.cloudtone.sugang_backend.domain.Subject;
import com.cloudtone.sugang_backend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByUser(User user);
    Optional<Course> findByUserAndSubject(User user, Subject subject);
}
