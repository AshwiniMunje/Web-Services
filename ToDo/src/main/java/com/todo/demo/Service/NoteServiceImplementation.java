package com.todo.demo.Service;

import com.todo.demo.Dao.NoteDao;
import com.todo.demo.Note.Note;
import com.todo.demo.Repository.NoteRepository;
import com.todo.demo.thrift.gen.NoteServiceThrift;
import com.todo.demo.thrift.gen.NoteThrift;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImplementation implements NoteService {

    @Autowired
    NoteDao noteDao;

    @Override
    public int createNote(Note note) {
        return noteDao.saveNote(note);
    }

    @Override
    public List<Note> readNote() {
        return noteDao.read();
    }

    @Override
    public void updateNote(Note note) {
        noteDao.update(note);
    }

    @Override
    public void deleteNote(int id) {
        noteDao.deleteNote(id);
    }

    @Override
    public String sayHello() {
        return "Hello World!";
    }

}
