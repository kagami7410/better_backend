package com.better.backend_app.controllers;

import com.better.backend_app.models.ActivityDate;
import com.better.backend_app.models.TimeSlot;
import com.better.backend_app.repositories.ActivityDateRepository;
import com.better.backend_app.repositories.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class TimeSlotController {

    @Autowired
    TimeSlotRepository timeSlotRepository;

    @Autowired
    ActivityDateRepository activityDateRepository;

    @GetMapping("timeSlot/getAll")
    public List<TimeSlot> getTimeSlot(){
        return timeSlotRepository.findAll();
    }
    @PostMapping("/timeSlot/add")
    public TimeSlot addTimeSlot(@RequestParam Integer startTime, @RequestParam Integer endTime, @RequestParam boolean availability, @RequestParam Long activityDateId){
        ActivityDate activityDate = activityDateRepository.findById(activityDateId).orElse(null);
        TimeSlot timeSlot = new TimeSlot();
        timeSlot.setStartTime(startTime);
        timeSlot.setEndTime(endTime);
        timeSlot.setAvailability(availability);
        timeSlot.setActivityDate(activityDate);
        timeSlotRepository.save(timeSlot);

//        activityDate.setTimeSlots(Arrays.asList(timeSlot));
//        activityDateRepository.save(activityDate);
//        timeSlotRepository.save(timeSlot);

        return  timeSlot;
    }
}
