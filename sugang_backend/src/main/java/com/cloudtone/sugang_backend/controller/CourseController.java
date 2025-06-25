package com.cloudtone.sugang_backend.controller;

import com.cloudtone.sugang_backend.dto.CourseRequest;
import com.cloudtone.sugang_backend.dto.CourseResponse;
import com.cloudtone.sugang_backend.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

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

@Controller
@RequestMapping("/courses")
class CourseViewController {
    private final CourseService courseService;
    public CourseViewController(CourseService courseService) {
        this.courseService = courseService;
    }

    // 내 수강신청 내역
    @GetMapping("/user/{userId}")
    public String myCourses(@PathVariable Long userId, Model model) {
        model.addAttribute("courses", courseService.getMyCourses(userId));
        return "my_courses";
    }

    // 수강신청 처리 (subject_detail.html에서 POST)
    @PostMapping("/apply")
    public String applyCourse(CourseRequest request) {
        courseService.applyCourse(request);
        return "redirect:/courses/user/" + request.getUserId();
    }

    // 수강신청 취소 (my_courses.html에서 POST)
    @PostMapping("/{courseId}")
    public String cancelCourse(@PathVariable Long courseId, @RequestParam Long userId) {
        courseService.cancelCourse(courseId);
        return "redirect:/courses/user/" + userId;
    }
}