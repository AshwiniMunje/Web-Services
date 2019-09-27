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

    NoteThrift createNote(1:NoteThrift note);

    list<NoteThrift> readNote(1:int pageNo, 2:int pageSize, 3:string sortBy);

    NoteThrift updateNote(1:NoteThrift note);

    NoteThrift deleteNote(1:int id);
}
