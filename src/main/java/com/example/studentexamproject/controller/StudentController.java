package com.example.studentexamproject.controller;

import com.example.studentexamproject.dto.ApiResponse;
import com.example.studentexamproject.dto.RegisterRequest;
import com.example.studentexamproject.dto.RegisterResponse;
import com.example.studentexamproject.service.StudentService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class StudentController {

    StudentService studentService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@Valid @RequestBody RegisterRequest request) {
        studentService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(RegisterResponse.builder()
                        .message("Qeydiyyat uğurlu oldu")
                        .status(201)
                        .timestamp(LocalDateTime.now())
                        .build());

    }
}
