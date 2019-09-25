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

    public Note() {
    }

    public Note toNote(NoteThrift noteThrift) {
        Note note = new Note();
        note.id = noteThrift.getId();
        note.name = noteThrift.getName();
        note.description = noteThrift.getDescription();
        PriorityThrift priorityThrift = noteThrift.getPriority();
        switch (priorityThrift) {
            case LOW:
                note.setPriority(Priority.LOW);
                break;
            case MEDIUM:
                note.setPriority(Priority.MEDIUM);
                break;
            case HIGH:
                note.setPriority(Priority.HIGH);
                break;
        }
        return note;
    }

    public NoteThrift toThriftNote() {
        NoteThrift noteThrift = new NoteThrift();
        noteThrift.setId(this.id);
        noteThrift.setName(this.name);
        noteThrift.setDescription(this.description);
        switch (this.priority) {
            case LOW:
                noteThrift.setPriority(PriorityThrift.LOW);
                break;
            case MEDIUM:
                noteThrift.setPriority(PriorityThrift.MEDIUM);
                break;
            case HIGH:
                noteThrift.setPriority(PriorityThrift.HIGH);
                break;
        }
        return noteThrift;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
