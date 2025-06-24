package com.cloudtone.sugang_backend.service;

import com.cloudtone.sugang_backend.domain.Course;
import com.cloudtone.sugang_backend.domain.Subject;
import com.cloudtone.sugang_backend.domain.User;
import com.cloudtone.sugang_backend.dto.CourseRequest;
import com.cloudtone.sugang_backend.dto.CourseResponse;
import com.cloudtone.sugang_backend.repository.CourseRepository;
import com.cloudtone.sugang_backend.repository.SubjectRepository;
import com.cloudtone.sugang_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final SubjectRepository subjectRepository;

    public Long applyCourse(CourseRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("유저 없음"));
        Subject subject = subjectRepository.findById(request.getSubjectId())
                .orElseThrow(() -> new IllegalArgumentException("과목 없음"));

        courseRepository.findByUserAndSubject(user, subject).ifPresent(c -> {
            throw new IllegalArgumentException("이미 신청한 과목입니다.");
        });

        Course course = Course.builder().user(user).subject(subject).build();
        return courseRepository.save(course).getId();
    }

    public void cancelCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    public List<CourseResponse> getMyCourses(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("유저 없음"));

        return courseRepository.findByUser(user).stream()
                .map(c -> new CourseResponse(
                        c.getId(),
                        user.getId(),
                        c.getSubject().getSubjectId(),
                        c.getSubject().getSubjectName(),
                        c.getSubject().getProfessor()))
                .collect(Collectors.toList());
    }
}