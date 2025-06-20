package com.cloudtone.sugang_backend.controller;

import com.cloudtone.sugang_backend.domain.Subject;
import com.cloudtone.sugang_backend.dto.SubjectRequest;
import com.cloudtone.sugang_backend.repository.UserRepository;
import com.cloudtone.sugang_backend.service.SubjectService;
import com.cloudtone.sugang_backend.service.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SugangController {
    private final SubjectService subjectService;
    private final UserDetailService userDetailService;

    // 회원 등록, 회원가입?
    @PostMapping("api/User")
    public void addUser(){

    }

    // 과목 등록
    @PostMapping("api/Subject")
    public ResponseEntity<Subject> addSubject(@RequestBody SubjectRequest request){
        Subject savedSubject = subjectService.save(request); // 입력한 과목 레포에 저장

        return ResponseEntity.status(HttpStatus.CREATED) // 저장 완료
                .body(savedSubject); // 저장한 과목 반환
    }






}
