package com.cloudtone.sugang_backend.service;

import com.cloudtone.sugang_backend.domain.Subject;
import com.cloudtone.sugang_backend.dto.SubjectRequest;
import com.cloudtone.sugang_backend.dto.SubjectResponse;
import com.cloudtone.sugang_backend.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    public Long save(SubjectRequest request) {
        Subject subject = Subject.builder()
                .subjectName(request.getSubjectName())
                .subjectCode(request.getSubjectCode())
                .professor(request.getProfessor())
                .grade(request.getGrade())
                .build();
        return subjectRepository.save(subject).getSubjectId();
    }

    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    public SubjectResponse findById(Long id) {
        Subject s = subjectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 과목이 존재하지 않습니다."));
        return new SubjectResponse(
                s.getSubjectId(),
                s.getSubjectName(),
                s.getSubjectCode(),
                s.getProfessor(),
                s.getGrade()
        );
    }

}