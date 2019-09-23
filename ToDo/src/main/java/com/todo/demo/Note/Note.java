package com.todo.demo.Note;

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

    public Note() {
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
