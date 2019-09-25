package com.todo.demo.Note;

import com.todo.demo.thrift.gen.NoteThrift;
import com.todo.demo.thrift.gen.PriorityThrift;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
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

    public static Note fromThriftNote(NoteThrift noteThrift) {
        PriorityThrift priorityThrift = noteThrift.getPriority();
        Priority priority = Priority.LOW;
        switch (priorityThrift) {
            case LOW:
                priority = Priority.LOW;
                break;
            case MEDIUM:
                priority = Priority.MEDIUM;
                break;
            case HIGH:
                priority = Priority.HIGH;
                break;
        }
        Note note = new Note(noteThrift.getId(), noteThrift.getName(), noteThrift.getDescription(), priority);
        return note;
    }

    public NoteThrift toThriftNote() {
        PriorityThrift priorityThrift = PriorityThrift.LOW;
        switch (this.priority) {
            case LOW:
                priorityThrift = PriorityThrift.LOW;
                break;
            case MEDIUM:
                priorityThrift = PriorityThrift.MEDIUM;
                break;
            case HIGH:
                priorityThrift = PriorityThrift.HIGH;
                break;
        }
        NoteThrift noteThrift = new NoteThrift(this.id, this.name, this.description, priorityThrift);
        return noteThrift;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
