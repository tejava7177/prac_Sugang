package com.cloudtone.sugang_backend.controller;

import com.cloudtone.sugang_backend.repository.UserRepository;
import com.cloudtone.sugang_backend.service.SubjectService;
import com.cloudtone.sugang_backend.service.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SugangController {
    private final SubjectService subjectServicel;
    private final UserDetailService userDetailService;

    // 회원 등록
    void addUser(){

    }

    // 과목 등록
    void addSubject(){
        
    }






}
