package com.example.studentexamproject.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiResponse {

    String message;
    int status;
    LocalDateTime timestamp;
    Object data;
}


