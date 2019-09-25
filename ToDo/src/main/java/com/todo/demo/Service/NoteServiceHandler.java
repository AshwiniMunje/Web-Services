package com.todo.demo.Service;

import com.todo.demo.Note.Note;
import com.todo.demo.thrift.gen.NoteServiceThrift;
import com.todo.demo.thrift.gen.NoteThrift;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteServiceHandler implements NoteServiceThrift.Iface {

    @Autowired
    private NoteService noteService;

    public NoteServiceHandler(NoteService noteService) {
        this.noteService = noteService;
    }

    @Override
    public String sayHello() throws TException {
        return noteService.sayHello();
    }

    @Override
    public int createNote(NoteThrift note) throws TException {
        Note n = new Note();
        n.toNote(note);
        noteService.createNote(n);
        return n.getId();
    }

    @Override
    public List<NoteThrift> readNote() throws TException {
        List<NoteThrift> noteThriftList = new ArrayList<>();

        for (Note n:noteService.readNote()) {
            noteThriftList.add(n.toThriftNote());
        }
        return noteThriftList;
    }

    //TODO: update return type
    @Override
    public void updateNote(NoteThrift note) throws TException {
        Note n = new Note();
        n.toNote(note);
        noteService.updateNote(n);
    }

    //TODO: update return type
    @Override
    public void deleteNote(int id) throws TException {
        noteService.deleteNote(id);
    }
}
