package com.example.studentexamproject.service;

import com.example.studentexamproject.dto.LoginRequest;
import com.example.studentexamproject.dto.RegisterResponse;
import com.example.studentexamproject.exceptions.ExamNotPassedException;
import com.example.studentexamproject.exceptions.QrAlreadyExistsException;
import com.example.studentexamproject.model.entity.FirstExam;
import com.example.studentexamproject.model.entity.SecondExam;
import com.example.studentexamproject.model.entity.Student;
import com.example.studentexamproject.repository.FirstExamRepository;
import com.example.studentexamproject.repository.SecondExamRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal=true)
@Transactional
public class SecondExamService {

    AuthService authService;
    FirstExamRepository firstExamRepository;
    SecondExamRepository secondExamRepository;
    QrCodeService qrCodeService;
    EmailService emailService;

    public RegisterResponse registerForSecondExam(LoginRequest request) {
        Student student=authService.authenticate(request.getEmail(),request.getPassword());

        FirstExam firstExam=firstExamRepository.findByStudent(student)
                .orElseThrow(()-> new ExamNotPassedException("birinci imtahan məlumatı tapılmadı"));
        if (!firstExam.getPass()){
            throw new ExamNotPassedException("Birinci imtahandan keçmədiniz...");
        }
        secondExamRepository.findByStudent(student).ifPresent(s -> {
            throw new QrAlreadyExistsException("Artıq ikinci imtahana qeydiyyatdan keçmisiniz");
        });

        SecondExam secondExam = SecondExam.builder()
                .student(student)
                .pass(false)
                .result(null)
                .build();

        secondExamRepository.save(secondExam);

        String qrUrl = qrCodeService.generateQr(secondExam.getId().toString());

        firstExam.setQrUrl(qrUrl);

        emailService.sendEmail(student.getEmail(), qrUrl);

        return RegisterResponse.builder()
                .message("Qeydiyyat uğurlu oldu")
                .status(201)
                .timestamp(LocalDateTime.now())
                .data(qrUrl)
                .build();
    }


}
