package org.example.tmabackend.services;

import org.apache.commons.validator.routines.EmailValidator;
import org.example.tmabackend.jpas.UserJPA;
import org.example.tmabackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(String username, String email, String user_password, String full_name) {
        UserJPA user = new UserJPA();

        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String encryptedPasswd = bcrypt.encode(user_password);

        user.setUsername(username);
        user.setEmail(email);
        user.setUser_password(encryptedPasswd);
        user.setFull_name(full_name);

        userRepository.save(user);
    }
    public boolean checkEmail(String email) {
        return EmailValidator.getInstance().isValid(email);
    }

    public boolean checkPassword(String user_password) {
        return user_password.length() >= 7;
    }

    public boolean checkUsername(String username) {
        return username.length() >= 6;
    }

    public boolean checkFullName(String full_name) {
        return full_name.length() >= 3;
    }

    public boolean authenticateUser(@RequestParam String username, @RequestParam String password) {
        UserJPA user = userRepository.findByUsername(username);
        if(user != null) {
            BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
            if(bcrypt.matches(password, user.getUser_password())) {
                return true;
            }
        }
        return false;
    }

    public UserJPA getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}

