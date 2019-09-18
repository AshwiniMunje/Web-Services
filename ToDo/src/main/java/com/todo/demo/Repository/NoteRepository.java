package com.todo.demo.Repository;


import com.todo.demo.Note.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoteRepository extends MongoRepository<Note, Integer> {

}
