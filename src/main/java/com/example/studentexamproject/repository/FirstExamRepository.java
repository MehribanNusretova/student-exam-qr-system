package com.example.studentexamproject.repository;

import com.example.studentexamproject.model.entity.FirstExam;
import com.example.studentexamproject.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FirstExamRepository extends JpaRepository<FirstExam, Long> {
    Optional<FirstExam> findByStudent(Student student);
}
