package org.example.tmabackend.controllers;

import org.example.tmabackend.jpas.ListJPA;
import org.example.tmabackend.services.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/list")
public class ListController {
    private ListService listService;

    @Autowired
    public ListController(ListService listService) {
        this.listService = listService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addList(@RequestParam int user_id, @RequestParam String list_name) {
        if(listService.addList(user_id, list_name)) {
            return new ResponseEntity<>("List Added!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Too many lists!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-lists")
    public ResponseEntity<?> getLists(@RequestParam int user_id) {
        List<ListJPA> list = listService.getListsByUser(user_id);
        if(list != null) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Something went wrong retrieving lists!", HttpStatus.BAD_REQUEST);
        }
    }
}
