package com.todo.demo.Resource;

import com.todo.demo.Note.Note;
import com.todo.demo.Repository.NoteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ToDo/notes")
public class NoteResource {

    private NoteRepository noteRepository;

    public NoteResource(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @GetMapping("/all")
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

}
