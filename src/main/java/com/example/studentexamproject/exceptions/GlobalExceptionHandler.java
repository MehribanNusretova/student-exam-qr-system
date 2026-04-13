package com.example.studentexamproject.exceptions;


import com.example.studentexamproject.dto.ApiResponse;
import com.example.studentexamproject.dto.RegisterResponse;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestControllerAdvice
  public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ApiResponse> handleInvalidCredentials(InvalidCredentialsException ex) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
              .body(new ApiResponse(ex.getMessage(), 401, LocalDateTime.now(),null));
    }

    @ExceptionHandler(ExamNotPassedException.class)
    public ResponseEntity<ApiResponse> handleNotPassed(ExamNotPassedException ex) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN)
              .body(new ApiResponse(ex.getMessage(), 403, LocalDateTime.now(),null));
    }

    @ExceptionHandler(QrAlreadyExistsException.class)
    public ResponseEntity<ApiResponse> handleQrExists(QrAlreadyExistsException ex) {
      return ResponseEntity.status(HttpStatus.CONFLICT)
              .body(new ApiResponse(ex.getMessage(),409, LocalDateTime.now(),null));
    }
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ApiResponse> handleQrExists(EmailAlreadyExistsException ex) {
      return ResponseEntity.status(HttpStatus.CONFLICT)
              .body(new ApiResponse(ex.getMessage(), 409, LocalDateTime.now(),null));
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleGeneral(Exception ex) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body(new ApiResponse("Internal server error", 500, LocalDateTime.now(),null));
    }

  }
