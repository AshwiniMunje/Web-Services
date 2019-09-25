package com.todo.demo.Dao;

import com.todo.demo.Note.Note;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface NoteDao {

    public String sayHello();
    Note saveNote(Note note);
    List<Note> listNote();
    Note update(Note note);
    Note deleteNote(int id);

}
