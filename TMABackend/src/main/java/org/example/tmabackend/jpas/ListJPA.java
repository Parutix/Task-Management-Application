package org.example.tmabackend.jpas;

import jakarta.persistence.*;

@Entity
@Table(name="user_lists", uniqueConstraints = {
        @UniqueConstraint(columnNames = "user_id")
})
public class ListJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int userId;
    @Column(name="list_id")
    private int listId;

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
}
