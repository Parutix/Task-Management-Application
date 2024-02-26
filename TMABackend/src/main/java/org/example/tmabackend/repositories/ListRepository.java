package org.example.tmabackend.repositories;

import org.example.tmabackend.jpas.ListJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends JpaRepository<ListJPA, Integer> {
}
