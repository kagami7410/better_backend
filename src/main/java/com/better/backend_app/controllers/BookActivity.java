package com.better.backend_app.controllers;

import com.better.backend_app.models.ActivityDate;
import com.better.backend_app.models.TimeSlot;
import com.better.backend_app.repositories.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class BookActivity {
    @Autowired
    TimeSlotRepository timeSlotRepository;

    @PutMapping("/book/activity")
    ResponseEntity<String> bookActivity (@RequestParam Long id, @RequestParam boolean booked){
        TimeSlot timeSlotToBeUpdated = timeSlotRepository.findById(id).orElse(null);
        System.out.println(timeSlotToBeUpdated.getId());
        timeSlotToBeUpdated.setAvailability(booked);
        timeSlotRepository.save(timeSlotToBeUpdated);
        ActivityDate activityDate = timeSlotToBeUpdated.getActivityDate();
        String activity = activityDate.getActivity().getName();
        LocalDate date = activityDate.getDate();
        return new ResponseEntity<>("Your booking for " + activity + " is confirmed on " + date + " from: " + timeSlotToBeUpdated.getStartTime() + " to " + timeSlotToBeUpdated.getEndTime(),
                HttpStatus.OK);


    }
}
