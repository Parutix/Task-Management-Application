package org.example.tmabackend.services;

import org.example.tmabackend.jpas.ListJPA;
import org.example.tmabackend.repositories.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListService {
    private final ListRepository listRepository;

    @Autowired
    public ListService(ListRepository listRepository) {
        this .listRepository = listRepository;
    }

    public boolean addList(int user_id, String list_name) {

        ListJPA list = new ListJPA();
        list.setUserId(user_id);
        list.setList_name(list_name);

        listRepository.save(list);
        return true;
    }

}
