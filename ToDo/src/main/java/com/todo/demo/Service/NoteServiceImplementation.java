package com.todo.demo.Service;

import com.todo.demo.Note.Note;
import com.todo.demo.Repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImplementation implements NoteService {

    @Autowired
    NoteRepository noteRepository;

    @Override
    public void createNote(Note note) {
        noteRepository.insert(note);
        //noteRepository.saveAll(note);
    }

    @Override
    public List<Note> readNote() {
        return noteRepository.findAll();
    }

    @Override
    public void updateNote(Note note) {
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
