package com.telema.notes.controllers;

import com.telema.notes.entities.User;
import com.telema.notes.handlers.ResponseHandler;
import com.telema.notes.services.UserService;
import com.telema.notes.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Object> getUsers() {
        return ResponseHandler.generateResponse(userService.getUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUser(@PathVariable Long id) {
        return ResponseHandler.generateResponse(userService.getUser(id));
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@Valid @RequestBody User note) {
        return ResponseHandler.generateResponse(userService.createUser(note));
    }

    @PutMapping
    public ResponseEntity<Object> updateUser(@RequestBody User note) {
        return ResponseHandler.generateResponse(userService.updateUser(note));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseHandler.generateResponse(
                null, "User deleted successfully!");
    }
}

