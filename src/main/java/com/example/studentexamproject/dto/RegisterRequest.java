package com.example.studentexamproject.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RegisterRequest {
    @NotBlank
    String name;
    @NotBlank
    String surname;
    @NotBlank
    @Email
    String email;
    @NotBlank
    String password;
}