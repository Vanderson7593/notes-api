package com.telema.notes.services;

import com.telema.notes.dtos.note.CreateUpdateNoteRequest;
import com.telema.notes.entities.Note;
import com.telema.notes.entities.User;
import com.telema.notes.exceptions.NoDataFoundException;
import com.telema.notes.mappers.NoteMapper;
import com.telema.notes.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteMapper noteMapper;

    @Autowired
    private NoteRepository noteRepository;

    public User getAuth() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public List<Note> getNotes() {
        return noteRepository.findAll();
    }

    public Optional<Note> getNote(Long id) {
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isEmpty()) {
            throw new NoDataFoundException();
        }
        return optionalNote;
    }

    public Note createNote(CreateUpdateNoteRequest note) {
        return noteRepository.save(Note.builder().title(note.title()).content(note.content()).user(getAuth()).build());
    }

    public Note updateNote(CreateUpdateNoteRequest note, Long id) {
        Note optionalNote = noteRepository.getReferenceById(id);
        noteMapper.updateNotePartial(note, optionalNote);
        return noteRepository.save(optionalNote);
    }

    public void deleteNote(Long id) {
        Optional<Note> optionalNotes = noteRepository.findById(id);
        if (optionalNotes.isEmpty()) {
            throw new NoDataFoundException();
        }

        noteRepository.deleteById(id);
    }

}
