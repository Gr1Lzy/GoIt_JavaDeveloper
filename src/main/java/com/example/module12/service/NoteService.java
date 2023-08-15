package com.example.module12.service;

import com.example.module12.entity.Note;
import com.example.module12.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    public Note add(Note note) {
        return noteRepository.save(note);
    }

    public void deleteById(long id) {
        noteRepository.deleteById(id);
    }

    public void update(Note note) {
        noteRepository.save(note);
    }

    public Note getById(long id) {
        return noteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid note Id: " + id));
    }
}
