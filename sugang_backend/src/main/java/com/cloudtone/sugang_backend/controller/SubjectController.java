package com.cloudtone.sugang_backend.controller;

import com.cloudtone.sugang_backend.domain.Subject;
import com.cloudtone.sugang_backend.dto.SubjectRequest;
import com.cloudtone.sugang_backend.dto.SubjectResponse;
import com.cloudtone.sugang_backend.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

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

@Controller
@RequestMapping("/subjects")
class SubjectViewController {
    private final SubjectService subjectService;
    public SubjectViewController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    // 과목 목록
    @GetMapping
    public String list(Model model) {
        model.addAttribute("subjects", subjectService.findAll());
        return "subjects";
    }

    // 과목 상세
    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("subject", subjectService.findById(id));
        return "subject_detail";
    }

    // 과목 등록 폼
    @GetMapping("/add")
    public String addForm() {
        return "subject_add";
    }

    // 과목 등록 처리
    @PostMapping("/add")
    public String addSubmit(SubjectRequest request) {
        subjectService.save(request);
        return "redirect:/subjects";
    }
}