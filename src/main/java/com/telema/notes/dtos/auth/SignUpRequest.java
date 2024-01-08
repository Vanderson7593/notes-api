package com.telema.notes.dtos.auth;

import com.telema.notes.entities.Role;
import jakarta.validation.constraints.NotBlank;
public record SignUpRequest(
        @NotBlank
        String name,
        @NotBlank
        String email,
        @NotBlank
        String password,
        Role role
) {
}
