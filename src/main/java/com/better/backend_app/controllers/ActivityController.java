package com.better.backend_app.controllers;

import com.better.backend_app.models.Activity;
import com.better.backend_app.models.LeisureCentre;
import com.better.backend_app.repositories.ActivityRepository;
import com.better.backend_app.repositories.LeisureCentreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ActivityController {
    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    LeisureCentreRepository leisureCentreRepository;

    @GetMapping("/activity/getAll")
    public List<Activity> getActivities(){
        return activityRepository.findAll();
    }

    @PostMapping("/activity/add")
    public ResponseEntity<String> addActivity(@RequestBody Activity activity, @RequestParam String LeisureCentreName){
        LeisureCentre leisureCentre = leisureCentreRepository.findByName(LeisureCentreName).orElse(null);
        activity.setLeisureCentre(leisureCentre);
        activityRepository.save(activity);
        return new ResponseEntity<>(activity.getName() + " added to " + activity.getLeisureCentre().getName() + " centre", HttpStatus.OK);
    }


}
