package org.example.tmabackend.repositories;

import org.example.tmabackend.jpas.ListJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListRepository extends JpaRepository<ListJPA, Integer> {
    List<ListJPA> findAllListsByUserId(int user_id);
    ListJPA findFirstByOrderByListIdDesc();
    int countByUserId(int user_id);
}
