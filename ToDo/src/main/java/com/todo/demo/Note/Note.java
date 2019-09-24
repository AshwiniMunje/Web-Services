package com.todo.demo.Note;

import com.todo.demo.thrift.gen.NoteThrift;
import com.todo.demo.thrift.gen.PriorityThrift;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//Mongo database annotation -- Model Class
@Document("Note")
@Data
@AllArgsConstructor
public class Note {

    @Id
    private Integer id;
    private String name;
    private String description;
    private Priority priority;

    public Note(NoteThrift note) {
        this.id = note.getId();
        this.name = note.getName();
        this.description = note.getDescription();
        this.priority = Priority.LOW;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
