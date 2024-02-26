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

    public void addList(int user_id, int list_id) {
        ListJPA list = new ListJPA();
        list.setUserId(user_id);
        list.setListId(list_id);

        listRepository.save(list);
    }

    public List<ListJPA> checkList(int user_id) {
        List<ListJPA> list = listRepository.findAllByUserId(user_id);
        return list;
    }
}
