package com.telema.notes.exceptions;

public class UnAuthorizedException extends RuntimeException {
    public UnAuthorizedException() {
        super("Unauthorized access");
    }
}