package com.cloudtone.sugang_backend.controller;

import com.cloudtone.sugang_backend.dto.CourseRequest;
import com.cloudtone.sugang_backend.dto.CourseResponse;
import com.cloudtone.sugang_backend.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    // 강의 등록
    @PostMapping
    public ResponseEntity<Long> applyCourse(@RequestBody CourseRequest request) {
        return ResponseEntity.ok(courseService.applyCourse(request));
    }

    // 수강 신청 내역 삭제
    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> cancelCourse(@PathVariable Long courseId) {
        courseService.cancelCourse(courseId);
        return ResponseEntity.ok().build();
    }

    // 단일 사용자의 수강신청 내역 조회
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CourseResponse>> getMyCourses(@PathVariable Long userId) {
        return ResponseEntity.ok(courseService.getMyCourses(userId));
    }
}