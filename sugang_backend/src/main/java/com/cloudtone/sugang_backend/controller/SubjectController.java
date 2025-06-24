package com.cloudtone.sugang_backend.controller;

import com.cloudtone.sugang_backend.domain.Subject;
import com.cloudtone.sugang_backend.dto.SubjectRequest;
import com.cloudtone.sugang_backend.dto.SubjectResponse;
import com.cloudtone.sugang_backend.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    // 과목 등록
    @PostMapping
    public ResponseEntity<Subject> save(@RequestBody SubjectRequest request) {
        Subject saved = subjectService.save(request);
        return ResponseEntity.ok(saved);
    }

    // 전체 과목 조회
    @GetMapping
    public ResponseEntity<List<Subject>> findAll() {
        return ResponseEntity.ok(subjectService.findAll());
    }

    // 단일 과목 조회
    @GetMapping("/{id}")
    public ResponseEntity<SubjectResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(subjectService.findById(id));
    }
}