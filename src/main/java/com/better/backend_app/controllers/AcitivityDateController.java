package com.better.backend_app.controllers;


//import com.better.backend_app.config.CalenderConfig;
import com.better.backend_app.models.ActivityDate;
import com.better.backend_app.repositories.ActivityDateRepository;
import com.better.backend_app.service.CalenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
public class AcitivityDateController {
    @Autowired
    CalenderService calenderService;

    @Autowired
    ActivityDateRepository activityDateRepository;

//    @Autowired
//
//    CalenderConfig calenderConfig;


//    @Autowired
//    @Qualifier("ActivityDate1")
//    ActivityDate activityDate1;
//
//    @Autowired
//    @Qualifier("ActivityDate2")
//    ActivityDate activityDate2;
//
//    @Autowired
//    @Qualifier("ActivityDate3")
//    ActivityDate activityDate3;
//
//    @Autowired
//    @Qualifier("ActivityDate4")
//    ActivityDate activityDate4;
//
//    @Autowired
//    @Qualifier("ActivityDate5")
//    ActivityDate activityDate5;
//
//    @Autowired
//    @Qualifier("ActivityDate6")
//    ActivityDate activityDate6;
//
//    @Autowired
//    @Qualifier("ActivityDate7")
//    ActivityDate activityDate7;
//

    @GetMapping("/getDates")
    public List<ActivityDate> getDates() {
        return activityDateRepository.findAll();
    }

    @DeleteMapping("/activityDate/deleteAll")
    public ResponseEntity<String> deleteActivityDate(){
        activityDateRepository.deleteAll();
        return new ResponseEntity<>("All ActivityDates Deleted", HttpStatus.OK);
    }
}
//    @GetMapping("/getDay")
//    public DayOfWeek getDay(){
//        return calenderService.
//}
