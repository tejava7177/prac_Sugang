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

    @PostMapping
    public ResponseEntity<Long> applyCourse(@RequestBody CourseRequest request) {
        return ResponseEntity.ok(courseService.applyCourse(request));
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> cancelCourse(@PathVariable Long courseId) {
        courseService.cancelCourse(courseId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CourseResponse>> getMyCourses(@PathVariable Long userId) {
        return ResponseEntity.ok(courseService.getMyCourses(userId));
    }
}