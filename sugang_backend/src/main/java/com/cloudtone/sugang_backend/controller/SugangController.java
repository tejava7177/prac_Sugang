package com.cloudtone.sugang_backend.controller;

import com.cloudtone.sugang_backend.domain.Subject;
import com.cloudtone.sugang_backend.dto.SubjectRequest;
import com.cloudtone.sugang_backend.repository.UserRepository;
import com.cloudtone.sugang_backend.service.SubjectService;
import com.cloudtone.sugang_backend.service.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SugangController {
    private final SubjectService subjectServicel;
    private final UserDetailService userDetailService;

    // 회원 등록
    @PostMapping("api/User")
    public void addUser(){

    }

    // 과목 등록
    @PostMapping("api/Subject")
    public ResponseEntity<Subject> addSubject(@RequestBody SubjectRequest request){
        
    }






}
