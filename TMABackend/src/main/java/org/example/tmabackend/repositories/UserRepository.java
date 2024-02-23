package org.example.tmabackend.repositories;

import org.example.tmabackend.jpas.UserJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserJPA, Integer> {
    UserJPA findByUsername(String username);

}
