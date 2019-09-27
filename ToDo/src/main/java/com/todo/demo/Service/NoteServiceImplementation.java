package com.todo.demo.Service;

import com.todo.demo.Dao.NoteDao;
import com.todo.demo.Note.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImplementation implements NoteService {

    @Autowired
    NoteDao noteDao;

    @Override
    public Note createNote(Note note) {
        return noteDao.saveNote(note);
    }

    @Override
    public List<Note> readNote(Integer pageNo, Integer pageSize, String sortBy) {
        return noteDao.listNote(pageNo, pageSize, sortBy);
    }

    @Override
    public Note updateNote(Note note) {
        noteDao.update(note);
        return note;
    }

    @Override
    public Note deleteNote(int id) {
        return (noteDao.deleteNote(id));
    }

    @Override
    public String sayHello() {
        return "Hello World!";
    }

}
