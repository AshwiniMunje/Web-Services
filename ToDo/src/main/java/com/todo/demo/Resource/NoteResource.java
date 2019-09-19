package com.todo.demo.Resource;

import com.todo.demo.Note.Note;
import com.todo.demo.Repository.NoteRepository;
import com.todo.demo.Service.NoteService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/ToDo/notes")
public class NoteResource {

    //private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    @Autowired
    NoteService noteService;

    @GetMapping("/hello")
    public String emptyNote() {
      //  logger.info("New Note");
        return noteService.sayHello();
    }

    @PostMapping(value="/add")
    public void addNote(@RequestBody Note note) {
       // logger.info("Adding new note");
        noteService.createNote(note);
    }

    @GetMapping("/all")
    public List<Note> getAllNotes() {
        //logger.info("Reading all notes");
        return noteService.readNote();
    }

    @PutMapping(value="/update/{note-id}")
    public void updateNote(@PathVariable(value="note-id") int id, @RequestBody Note n) {
        //logger.info("Updating note with id " + id);
        n.setId(id);
        noteService.updateNote(n);
    }

    @PutMapping(value="/delete/{note-id}")
    public void delNote(@PathVariable(value="note-id") int id) {
        //logger.info("Removing note with id " + id);
        noteService.deleteNote(id);
    }

}
