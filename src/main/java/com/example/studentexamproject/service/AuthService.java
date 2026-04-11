package com.example.studentexamproject.service;

import com.example.studentexamproject.exceptions.InvalidCredentialsException;
import com.example.studentexamproject.model.entity.Student;
import com.example.studentexamproject.repository.StudentRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthService {
    StudentRepository studentRepository;
    PasswordEncoder passwordEncoder;
    public Student authenticate(String email, String password) {
        Student student = studentRepository.findByEmail(email).orElseThrow(()->new InvalidCredentialsException("email və ya şifrə yanlışdır"));
        if(!passwordEncoder.matches(password, student.getPassword())) {
            throw new InvalidCredentialsException("Email və ya şifrə yanlışdır");
        }
        return student;
    }
}
