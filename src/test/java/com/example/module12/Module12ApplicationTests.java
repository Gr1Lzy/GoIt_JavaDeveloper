package com.example.module12;

import com.example.module12.entity.Note;
import com.example.module12.repository.NoteRepository;
import com.example.module12.service.NoteService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class Module12ApplicationTests {
    @Mock
    private NoteRepository noteRepository;

    @Test
    void testAdd() {
        //When
        NoteService noteService = new NoteService(noteRepository);
        Note noteToAdd = new Note();
        noteToAdd.setTitle("TestTitle");
        noteToAdd.setContent("TestContent");
        when(noteRepository.save(noteToAdd)).thenReturn(noteToAdd);

        //Then
        Note addedNote = noteService.add(noteToAdd);
        assertEquals(noteToAdd, addedNote);
    }
}
