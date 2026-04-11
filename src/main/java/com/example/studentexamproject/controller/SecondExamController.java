package com.example.studentexamproject.controller;

import com.example.studentexamproject.dto.ApiResponse;
import com.example.studentexamproject.dto.LoginRequest;
import com.example.studentexamproject.dto.RegisterResponse;
import com.example.studentexamproject.model.entity.SecondExam;
import com.example.studentexamproject.service.QrCodeService;
import com.example.studentexamproject.service.SecondExamService;
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
@RequestMapping("/secondExam")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SecondExamController {

    SecondExamService secondExamService;
    QrCodeService qrCodeService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> register(@Valid @RequestBody LoginRequest request) {



        RegisterResponse response = secondExamService.registerForSecondExam(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.builder()
                        .message(response.getMessage())
                        .status(201)
                        .timestamp(LocalDateTime.now())
                        .data(response.getData())
                        .build());

    }
}

