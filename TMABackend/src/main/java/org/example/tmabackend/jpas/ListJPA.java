package org.example.tmabackend.jpas;

import jakarta.persistence.*;

@Entity
@Table(name="user_lists", uniqueConstraints = {
        @UniqueConstraint(columnNames = "user_id")
})
public class ListJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private int list_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getList_id() {
        return list_id;
    }

    public void setList_id(int list_id) {
        this.list_id = list_id;
    }
}
