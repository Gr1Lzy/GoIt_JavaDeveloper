package com.example.module12;

import com.example.module12.entity.Note;
import com.example.module12.service.NoteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Module12Application {

    public static void main(String[] args) {
        SpringApplication.run(Module12Application.class, args);

        Note note = new Note();
        note.setTitle("Hi");
        note.setContent("Hello");

        NoteService noteService = new NoteService();
        noteService.add(note);
        noteService.add(note);
        System.out.println(noteService.listAll());
    }
}
