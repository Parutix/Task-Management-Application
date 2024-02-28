package org.example.tmabackend.jpas;

import jakarta.persistence.*;

@Entity
@Table(name="list_todos", uniqueConstraints = {
        @UniqueConstraint(columnNames = "todo_id")
})
public class TodoJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int todo_id;
    private int list_id;
    private String todo_description;
    private String todo_status;

    public int getTodo_id() {
        return todo_id;
    }

    public void setTodo_id(int todo_id) {
        this.todo_id = todo_id;
    }

    public int getList_id() {
        return list_id;
    }

    public void setList_id(int list_id) {
        this.list_id = list_id;
    }

    public String getTodo_description() {
        return todo_description;
    }

    public void setTodo_description(String todo_description) {
        this.todo_description = todo_description;
    }

    public String getTodo_status() {
        return todo_status;
    }

    public void setTodo_status(String todo_status) {
        this.todo_status = todo_status;
    }
}
