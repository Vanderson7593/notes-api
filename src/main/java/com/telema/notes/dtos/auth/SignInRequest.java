package com.telema.notes.dtos.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public record SignInRequest(
        @NotBlank
        String email,
        @NotBlank
        String password) {
}
