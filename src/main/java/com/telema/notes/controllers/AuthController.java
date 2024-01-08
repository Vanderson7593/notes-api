package com.telema.notes.controllers;

import com.telema.notes.dtos.auth.SignInRequest;
import com.telema.notes.dtos.auth.SignUpRequest;
import com.telema.notes.entities.User;
import com.telema.notes.handlers.ResponseHandler;
import com.telema.notes.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/me")
    public ResponseEntity<Object> me(@AuthenticationPrincipal User user){
        return ResponseHandler.generateResponse(user);
    }

    @PostMapping("/signup")
    public ResponseEntity<Object> signUp(@RequestBody @Valid SignUpRequest request) {
        return ResponseHandler.generateResponse(authService.signUp(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<Object> signIn(@RequestBody @Valid SignInRequest request) {
        return ResponseHandler.generateResponse(authService.signIn(request));
    }
}
