package com.telema.notes.services;

import com.telema.notes.config.JwtService;
import com.telema.notes.dtos.auth.SignInRequest;
import com.telema.notes.dtos.auth.SignUpRequest;
import com.telema.notes.entities.User;
import com.telema.notes.exceptions.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService service;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;

    public User signUp(SignUpRequest request) {

        var user = User.builder()
                .name(request.name())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(request.role())
                .build();

        return service.createUser(user);
    }

    public String signIn(SignInRequest request) {
            var auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.email(), request.password())
            );
            return jwtService.generateToken((User) auth.getPrincipal());
    }

}
