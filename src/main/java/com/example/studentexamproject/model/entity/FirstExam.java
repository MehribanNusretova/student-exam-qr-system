package com.example.studentexamproject.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;




@Entity
@Table(name="first_exam")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FirstExam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Student_id",unique=true)
    Student student;

    Boolean pass;

   Integer result;
    @Column(name = "second_exam_qr_url", columnDefinition = "TEXT")
    String QrUrl;
}
