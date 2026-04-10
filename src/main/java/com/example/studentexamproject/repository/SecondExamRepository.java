package com.example.studentexamproject.repository;

import com.example.studentexamproject.model.entity.SecondExam;
import com.example.studentexamproject.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SecondExamRepository extends JpaRepository<SecondExam, Long> {
    Optional<SecondExam> findByStudent(Student student);
}
