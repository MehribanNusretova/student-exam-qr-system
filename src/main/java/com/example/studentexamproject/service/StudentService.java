package com.example.studentexamproject.service;

import com.example.studentexamproject.dto.RegisterRequest;
import com.example.studentexamproject.exceptions.EmailAlreadyExistsException;
import com.example.studentexamproject.model.entity.FirstExam;
import com.example.studentexamproject.model.entity.Student;
import com.example.studentexamproject.repository.FirstExamRepository;
import com.example.studentexamproject.repository.StudentRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentService {

    StudentRepository studentRepository;
    PasswordEncoder passwordEncoder;
    FirstExamRepository firstExamRepository;
    public void register(RegisterRequest request) {
        if (studentRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException("Bu email artıq mövcuddur");
        }
        Student student = Student.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        studentRepository.save(student);

        FirstExam firstExam = FirstExam.builder()
                .student(student)
                .pass(false)
                .build();
        firstExamRepository.save(firstExam);
    }

}
