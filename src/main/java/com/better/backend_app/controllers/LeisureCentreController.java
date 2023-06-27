package com.better.backend_app.controllers;

import com.better.backend_app.models.LeisureCentre;
import com.better.backend_app.repositories.LeisureCentreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LeisureCentreController {
    @Autowired
    LeisureCentreRepository leisureCentreRepository;
    @GetMapping("/leisureCentre/getAll")
    public List<LeisureCentre> getLeisureCentre(){
        return leisureCentreRepository.findAll();
    }
    @PostMapping("/leisureCentre/add")
    public ResponseEntity<String> addLeiureCentre(@RequestBody LeisureCentre leisureCentre){
        LeisureCentre newLeisureCentre = leisureCentreRepository.save(leisureCentre);
        return new ResponseEntity<>(newLeisureCentre.getName() + " saved!", HttpStatus.OK);
    }

    @DeleteMapping("/leisureCentre/deleteAll")
    public ResponseEntity<String> deleteLeisureAllCentres(){
        leisureCentreRepository.deleteAll();
        return new ResponseEntity<>("All LeisureCentre Deleted", HttpStatus.OK);
    }

    @DeleteMapping("/leisureCentre/delete")
    public ResponseEntity<String> deleteLeisureCentre(@RequestParam String leisureCentreName){
        LeisureCentre leisureCentre = leisureCentreRepository.findByName(leisureCentreName).orElse(null);
        leisureCentreRepository.delete(leisureCentre);
        return new ResponseEntity<>("All LeisureCentre Deleted", HttpStatus.OK);
    }
}
