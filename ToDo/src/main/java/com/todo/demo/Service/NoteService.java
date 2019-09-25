package com.todo.demo.Service;

import com.todo.demo.Note.Note;
import com.todo.demo.Note.Priority;

import java.util.List;

public interface NoteService {

    public String sayHello();

    public Note createNote(Note note);

    public List<Note> readNote();

    public Note updateNote(Note note);

    public Note deleteNote(int id);

}
