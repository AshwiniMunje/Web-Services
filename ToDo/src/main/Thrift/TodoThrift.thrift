namespace java com.todo.demo.thrift.gen

typedef i32 int

enum PriorityThrift {
    LOW = 0,
    MEDIUM = 1,
    HIGH = 2;
}

struct NoteThrift {
     1:int id;
     2:string name;
     3:string description;
     4:PriorityThrift priority;
}

service NoteServiceThrift {

    string sayHello();

    int createNote(1:NoteThrift note);

    list<NoteThrift> readNote();

    void updateNote(1:NoteThrift note);

    void deleteNote(1:int id);
}
