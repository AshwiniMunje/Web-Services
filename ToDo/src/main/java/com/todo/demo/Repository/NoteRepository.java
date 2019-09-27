package com.todo.demo.Repository;


import com.todo.demo.Note.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends PagingAndSortingRepository<Note, Integer> {

}
