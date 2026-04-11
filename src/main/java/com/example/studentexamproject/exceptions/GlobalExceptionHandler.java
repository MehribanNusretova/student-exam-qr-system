package com.example.studentexamproject.exceptions;


import com.example.studentexamproject.dto.ApiResponse;
import com.example.studentexamproject.dto.RegisterResponse;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestControllerAdvice
  public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<RegisterResponse> handleInvalidCredentials(InvalidCredentialsException ex) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
              .body(new RegisterResponse(ex.getMessage(), 401, LocalDateTime.now()));
    }

    @ExceptionHandler(ExamNotPassedException.class)
    public ResponseEntity<RegisterResponse> handleNotPassed(ExamNotPassedException ex) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN)
              .body(new RegisterResponse(ex.getMessage(), 403, LocalDateTime.now()));
    }

    @ExceptionHandler(QrAlreadyExistsException.class)
    public ResponseEntity<RegisterResponse> handleQrExists(QrAlreadyExistsException ex) {
      return ResponseEntity.status(HttpStatus.CONFLICT)
              .body(new RegisterResponse(ex.getMessage(),409, LocalDateTime.now()));
    }
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<RegisterResponse> handleQrExists(EmailAlreadyExistsException ex) {
      return ResponseEntity.status(HttpStatus.CONFLICT)
              .body(new RegisterResponse(ex.getMessage(), 409, LocalDateTime.now()));
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<RegisterResponse> handleGeneral(Exception ex) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body(new RegisterResponse("Internal server error", 500, LocalDateTime.now()));
    }

  }
