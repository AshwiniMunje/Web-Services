package com.todo.demo.Service;

import com.todo.demo.Note.Note;
import com.todo.demo.Note.Priority;

import java.util.List;

public interface NoteService {

    public String sayHello();

    public int createNote(Note note);

    public List<Note> readNote();

    public void updateNote(Note note);

    public void deleteNote(int id);

}
