package com.todo.demo.Dao;

import com.todo.demo.Note.Note;
import com.todo.demo.Repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class NoteDaoImpl implements NoteDao {

    @Autowired
    NoteRepository noteRepository;

    @Override
    public Note saveNote(Note note) {
        int id = note.getId();
        if (noteRepository.existsById(id)) {
            note.setId((int) noteRepository.count());
        }
        noteRepository.insert(note);
        return note;
    }

    @Override
    public List<Note> listNote() {
        return noteRepository.findAll();
    }

    @Override
    public Note update(Note note) {
        noteRepository.save(note);
        return note;
    }

    @Override
    public Note deleteNote(int id) {
        List<Note> noteList = noteRepository.findAll();
        for(Note n:noteList) {
            if (n.getId() == id) {
                noteRepository.deleteById(id);
                return n;
            }
        }
        // No Node found with id
        System.out.println("Note to be deleted does not exist");
        return null;
    }

    @Override
    public String sayHello() {
        return "Hello World!";
    }
}
