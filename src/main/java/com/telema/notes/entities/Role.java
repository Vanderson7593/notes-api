package com.telema.notes.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
    ADMIN("admin"),
    USER("user");

    private final String role;
}
