package com.todo.demo.Note;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Note {
    @Id
    private Integer id;
    private String name;
    private String description;
    private Priority priority;

    public Note(Integer id, String name, String description, Priority priority) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priority = priority;
    }
/*
    public Note(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priority = Priority.low;
    }

    public Note(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.description = "This is a empty/new note";
        this.priority = Priority.low;
    }
*/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
