package com.todo.demo.Repository;


import com.todo.demo.Note.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Data-Access-Object (DAO) interface
@Repository
public interface NoteRepository extends MongoRepository<Note, Integer> {

}
