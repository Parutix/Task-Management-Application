package org.example.tmabackend.jpas;

import jakarta.persistence.*;

@Entity
@Table(
        name="user_lists",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"list_id"})
        }
)

public class ListJPA {
    @Column(name="user_id")
    private int userId;
    @Id
    @Column(name="list_id")
    private int listId;
    private String list_name;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public String getList_name() {
        return list_name;
    }

    public void setList_name(String list_name) {
        this.list_name = list_name;
    }
}
