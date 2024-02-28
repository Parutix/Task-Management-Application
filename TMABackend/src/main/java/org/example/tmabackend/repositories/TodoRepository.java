package org.example.tmabackend.repositories;

import org.example.tmabackend.jpas.TodoJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoJPA, Integer> {
}
