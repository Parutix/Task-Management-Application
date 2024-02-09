package org.example.tmabackend.services;

import org.example.tmabackend.jpas.UserJPA;
import org.example.tmabackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(String username, String email, String user_password, String full_name) {
        UserJPA user = new UserJPA();

        user.setUsername(username);
        user.setEmail(email);
        user.setUser_password(user_password);
        user.setFull_name(full_name);

        userRepository.save(user);
    }
}
