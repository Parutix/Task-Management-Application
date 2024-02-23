package org.example.tmabackend.controllers;

import org.example.tmabackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/auth")
public class AuthenticationController {
    private UserService userService;

    @Autowired
    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestParam String username, @RequestParam String email, @RequestParam String full_name, @RequestParam String user_password) {
        if(userService.checkEmail(email) == false) {
            return new ResponseEntity<>("Invalid Email!", HttpStatus.BAD_REQUEST);
        }

        if(userService.checkPassword(user_password) == false) {
            return new ResponseEntity<>("Invalid Password!", HttpStatus.BAD_REQUEST);
        }

        if(userService.checkUsername(username) == false) {
            return new ResponseEntity<>("Invalid Username!", HttpStatus.BAD_REQUEST);
        }

        if(userService.checkFullName(full_name) == false) {
            return new ResponseEntity<>("Invalid Full Name!", HttpStatus.BAD_REQUEST);
        }

        userService.registerUser(
                username,
                email,
                user_password,
                full_name
        );

        return new ResponseEntity<>("User Registered Successfully!", HttpStatus.OK);
    }

    @GetMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestParam String username, @RequestParam String password) {
        if(userService.authenticateUser(username, password) == true) {
            return new ResponseEntity<>("User Logged In Succesfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Wrong Username or Password", HttpStatus.BAD_REQUEST);
        }
    }

}
