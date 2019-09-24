package com.todo.demo.Dao;

import com.todo.demo.Note.Note;
import com.todo.demo.Repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NoteDaoImpl implements NoteDao {

    @Autowired
    NoteRepository noteRepository;

    @Override
    public int saveNote(Note note) {
        noteRepository.insert(note);
        return note.getId();
    }

    @Override
    public List<Note> read() {
        return noteRepository.findAll();
    }

    @Override
    public void update(Note note) {
        noteRepository.save(note);
    }

    @Override
    public void deleteNote(int id) {
        noteRepository.deleteById(id);
    }

    @Override
    public String sayHello() {
        return "Hello World!";
    }
}
