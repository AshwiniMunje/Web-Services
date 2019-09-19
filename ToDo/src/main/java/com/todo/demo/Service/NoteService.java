package com.todo.demo.Service;

import com.todo.demo.Note.Note;
import com.todo.demo.Note.Priority;

import java.util.List;

public interface NoteService {

    public String sayHello();

    //Create
    public void createNote(Note note);

    //Read
    public List<Note> readNote();

    //Update
    public void updateNote(Note note);

    //Delete
    public void deleteNote(int id);

}
