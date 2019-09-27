package com.todo.demo.Dao;

import com.todo.demo.Note.Note;

import java.util.List;

public interface NoteDao {

    public String sayHello();
    Note saveNote(Note note);
    List<Note> listNote(Integer pageNo, Integer pageSize, String sortBy);
    Note update(Note note);
    Note deleteNote(int id);

}
