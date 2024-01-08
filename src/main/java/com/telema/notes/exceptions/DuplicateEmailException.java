package com.telema.notes.exceptions;

public class DuplicateEmailException extends RuntimeException {
    public DuplicateEmailException() {
        super("Email already exists");
    }
}
