package com.example.module12.controller;

import com.example.module12.entity.Note;
import com.example.module12.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;

    @GetMapping("/create")
    public RedirectView create(@ModelAttribute Note note) {
        noteService.add(note);
        return new RedirectView("list");
    }

    @GetMapping("/list")
    public ModelAndView getAll(ModelAndView result) {
        result.addObject("notes", noteService.listAll());
        return result;
    }

    @PostMapping("/delete")
    public RedirectView delete(@RequestParam long id) {
        noteService.deleteById(id);
        return new RedirectView("list");
    }

    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam long id, ModelAndView result) {
        result.addObject("note", noteService.getById(id));
        return result;
    }

    @PostMapping("/edit")
    public RedirectView editRedirect(@ModelAttribute Note note) {
        noteService.update(note);
        return new RedirectView("list");
    }
}
