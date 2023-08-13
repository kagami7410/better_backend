package com.better.backend_app.controllers;

import com.better.backend_app.httpSecurity.config.services.AuthenticationService;
import com.better.backend_app.models.AuthenticationRequest;
import com.better.backend_app.models.AuthenticationResponse;
import com.better.backend_app.models.RegisterRequest;
import com.better.backend_app.models.User;
import com.better.backend_app.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final AuthenticationService authenticationService;

    @Autowired
    private UserRepository userRepository;



    @PostMapping("/register")
    private ResponseEntity<AuthenticationResponse> addUser(
            @RequestBody RegisterRequest request){
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
            ){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @GetMapping("users/getAll")
    private List<User> getUsers(){
        return userRepository.findAll();
    }

    @DeleteMapping("users/delete")
    private String deleteUser(@RequestParam Long id){
        User user = userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
        String name = user.getFirstName();
        return "User: " + name + " deleted!";
    }
}