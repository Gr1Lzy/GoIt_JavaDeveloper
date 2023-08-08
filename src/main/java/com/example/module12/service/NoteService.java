package com.example.module12.service;

import com.example.module12.entity.Note;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


@Service
public class NoteService {
    private final Map<Long, Note> notes = new HashMap<>();

    public List<Note> listAll() {
        return notes.values().stream().toList();
    }

    public Note add(Note note) {
        note.setId(new Random().nextLong());
        notes.put(note.getId(), note);
        return note;
    }

    public void deleteById(long id) {
        if (notes.containsKey(id)) {
            notes.remove(id);
        } else {
            throw new NullPointerException("Note doesn't exist");
        }
    }

    public void update(Note note) {
        if(notes.containsKey(note.getId())) {
            notes.put(note.getId(), note);
        } else {
            throw new NullPointerException("Note doesn't exist");
        }
    }

    public Note getById(long id) {
        return notes.get(id);
    }
}
