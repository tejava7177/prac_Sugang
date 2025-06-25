package com.cloudtone.sugang_backend.controller;


import com.cloudtone.sugang_backend.domain.Course;
import com.cloudtone.sugang_backend.domain.Subject;
import com.cloudtone.sugang_backend.domain.User;
import com.cloudtone.sugang_backend.dto.AddUserRequest;
import com.cloudtone.sugang_backend.dto.SubjectRequest;
import com.cloudtone.sugang_backend.repository.CourseRepository;
import com.cloudtone.sugang_backend.repository.SubjectRepository;
import com.cloudtone.sugang_backend.repository.UserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;




@SpringBootTest
@AutoConfigureMockMvc // MockMvc 생성 및 자동 구성
public class SugangApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper; //직열화, 역직열화를 위한 클래스

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private CourseRepository courseRepository;

    @BeforeEach
    public void mockMvcSetup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        courseRepository.deleteAll();
        subjectRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("유저 생성")
    public void addUser() throws Exception {
        //given
        final String url = "/api/users";
        final String student_id = "20214031";
        final String password = "password!";
        final String name = "유재은";
    }

}
