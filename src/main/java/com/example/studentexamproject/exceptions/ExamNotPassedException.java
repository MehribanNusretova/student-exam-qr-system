package com.example.studentexamproject.exceptions;

public class ExamNotPassedException extends RuntimeException {
    public ExamNotPassedException(String message) {
        super(message);
    }
}
