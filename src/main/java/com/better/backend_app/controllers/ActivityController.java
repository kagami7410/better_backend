package com.better.backend_app.controllers;


import com.better.backend_app.models.Activity;
import com.better.backend_app.models.ActivityDate;
import com.better.backend_app.models.LeisureCentre;
import com.better.backend_app.repositories.ActivityDateRepository;
import com.better.backend_app.repositories.ActivityRepository;
import com.better.backend_app.repositories.LeisureCentreRepository;
import com.better.backend_app.service.CalenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class ActivityController {
    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    LeisureCentreRepository leisureCentreRepository;

//    @Autowired
//    CalenderConfig calenderConfig;

    @Autowired
    ActivityDateRepository activityDateRepository;

    @Autowired
    CalenderService calenderService;

    @GetMapping("/activity/getAll")
    public List<Activity> getActivities(){
        return activityRepository.findAll();
    }

    @DeleteMapping("/activity/deleteAll")
    public ResponseEntity<String> deleteAllActivities(){
        activityRepository.deleteAll();
        return new ResponseEntity<>("All Activities Deleted", HttpStatus.OK);
    }

    @DeleteMapping("/activity/delete")
    public ResponseEntity<String> deleteActivity(@RequestParam String name, @RequestParam String leisureCentreName){
        LeisureCentre leisureCentre = leisureCentreRepository.findByName(leisureCentreName).orElse(null);
        Activity activity = activityRepository.findActivityByNameAndLeisureCentre(name, leisureCentre);
        activityRepository.delete(activity);
        return new ResponseEntity<>(name + " deleted in " + leisureCentreName + "!", HttpStatus.OK);
    }

    @PostMapping("/activity/add")
    public ResponseEntity<String> addActivity(@RequestBody Activity activity, @RequestParam String LeisureCentreName){
        LeisureCentre leisureCentre = leisureCentreRepository.findByName(LeisureCentreName).orElse(null);
        activity.setLeisureCentre(leisureCentre);
        activityRepository.save(activity);
        List<ActivityDate> activityDates = calenderService.createActivityDatesofSevenDays();
        activityDates.stream()
                .forEach(activityDate -> {
                    activityDate.setActivity(activity);
                    activityDateRepository.save(activityDate);
                });


        return new ResponseEntity<>(activity.getName() + " added to " + activity.getLeisureCentre().getName() + " centre", HttpStatus.OK);
    }
    @GetMapping("/getDay")
    public DayOfWeek getDay(){
        return calenderService.getDay();
    }


}
