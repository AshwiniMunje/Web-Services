package com.todo.demo;

import com.todo.demo.Note.Priority;
import com.todo.demo.thrift.gen.NoteServiceThrift;
import com.todo.demo.thrift.gen.NoteThrift;
import com.todo.demo.thrift.gen.PriorityThrift;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThriftClient
{
    private NoteServiceThrift.Client client;

    @Test
    public void mtest1() throws TException {
        THttpClient tHttpClient = new THttpClient("http://localhost:8081/todo/notes");

        TProtocol protocol = new TJSONProtocol(tHttpClient);

        client = new NoteServiceThrift.Client(protocol);

        String result = client.sayHello();
        System.out.println("Return from server: " + result);

        List<NoteThrift> allNotes = client.readNote();
        for (NoteThrift nt:allNotes) {
            System.out.println("Notes " + nt.toString());
        }

        NoteThrift noteThrift = client.createNote(new NoteThrift(55, "Hospital", "Complete hospital tasks", PriorityThrift.MEDIUM));
        System.out.println("Note Created: " + noteThrift.toString());

        List<NoteThrift> addedNote = client.readNote();
        for (NoteThrift nt:addedNote) {
            System.out.println("Notes " + nt.toString());
        }

        NoteThrift delNoteThrift = client.deleteNote(2);
        System.out.println("Deleted note : " + delNoteThrift.toString());


        noteThrift.setId(63);
        NoteThrift noteThrift1 = client.updateNote(noteThrift);
        System.out.println("Updated note: " + noteThrift1);
    }

}


