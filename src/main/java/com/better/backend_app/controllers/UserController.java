package com.better.backend_app.controllers;

import com.better.backend_app.httpSecurity.config.JwtAuthenticationFilter;
import com.better.backend_app.httpSecurity.config.services.AuthenticationService;
import com.better.backend_app.securityModels.AuthenticationRequest;
import com.better.backend_app.securityModels.AuthenticationResponse;
import com.better.backend_app.securityModels.RegisterRequest;
import com.better.backend_app.models.User;
import com.better.backend_app.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(UserController.class);


    @PostMapping("/register")
    private ResponseEntity<AuthenticationResponse> addUser(
            @RequestBody RegisterRequest request){
        return ResponseEntity.ok(authenticationService.register(request));
    }

//    @PostMapping("/authenticate")
//    public String authenticate(
//            @RequestBody AuthenticationRequest request
//            ){
//        return request.getEmail();
//    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        logger.info("Autenticating...");
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @GetMapping("/users/getAll")
    private String getUsers(){
       return "hi";
    }

    @DeleteMapping("users/delete")
    private String deleteUser(@RequestParam Long id){
        User user = userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
        String name = user.getFirstName();
        return "User: " + name + " deleted!";
    }
}