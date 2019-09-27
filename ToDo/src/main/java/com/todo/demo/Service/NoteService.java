package com.todo.demo.Service;

import com.todo.demo.Note.Note;

import java.util.List;

public interface NoteService {

    public String sayHello();

    public Note createNote(Note note);

    public List<Note> readNote(Integer pageNo, Integer pageSize, String sortBy);

    public Note updateNote(Note note);

    public Note deleteNote(int id);

}
