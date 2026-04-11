package com.example.studentexamproject.exceptions;

public class QrAlreadyExistsException extends RuntimeException {
    public QrAlreadyExistsException(String message) {
        super(message);
    }
}
