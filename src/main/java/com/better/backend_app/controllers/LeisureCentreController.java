package com.better.backend_app.controllers;

import com.better.backend_app.models.LeisureCentre;
import com.better.backend_app.repositories.LeisureCentreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Predicate;

@RestController
public class LeisureCentreController {
    @Autowired
    LeisureCentreRepository leisureCentreRepository;
    @CrossOrigin
    @GetMapping("/leisureCentre/getAll")
    public List<LeisureCentre> getLeisureCentre(){
        return leisureCentreRepository.findAll();
    }
    @PostMapping("/leisureCentre/add")
    public ResponseEntity<String> addLeiureCentre(@RequestBody LeisureCentre leisureCentre){
        List<LeisureCentre> leisureCentres = leisureCentreRepository.findAll();
        boolean leisureCentreExists = leisureCentres.stream()
                .anyMatch( leisureCentre1 -> leisureCentre1.getName().equals(leisureCentre.getName()));

        if (leisureCentreExists == true){
            return new ResponseEntity<>(leisureCentre.getName() + " already exists", HttpStatus.BAD_REQUEST);
        }
        else{
            LeisureCentre newLeisureCentre = leisureCentreRepository.save(leisureCentre);
            return new ResponseEntity<>(newLeisureCentre.getName() + " saved!", HttpStatus.CREATED);
        }
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
