package com.telema.notes.controllers;

import com.telema.notes.dtos.note.CreateUpdateNoteRequest;
import com.telema.notes.entities.Note;
import com.telema.notes.handlers.ResponseHandler;
import com.telema.notes.services.NoteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping
    public ResponseEntity<Object> getNotes() {
        return ResponseHandler.generateResponse(noteService.getNotes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getNote(@PathVariable Long id) {
        return ResponseHandler.generateResponse(noteService.getNote(id));
    }

    @PostMapping
    public ResponseEntity<Object> createNote(@Valid @RequestBody CreateUpdateNoteRequest note) {
        return ResponseHandler.generateResponse(noteService.createNote(note));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateNote(@RequestBody CreateUpdateNoteRequest note, @PathVariable Long id) {
        return ResponseHandler.generateResponse(noteService.updateNote(note, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return ResponseHandler.generateResponse(
                null, "Note deleted successfully!");
    }
}

