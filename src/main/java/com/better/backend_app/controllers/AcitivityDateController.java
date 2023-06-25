package com.better.backend_app.controllers;


import com.better.backend_app.models.ActivityDate;
import com.better.backend_app.service.CalenderService;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;

@RestController
public class AcitivityDateController {
    @Autowired
    CalenderService calenderService;

//    @GetMapping("/getDates")
//    public ActivityDate getDates(){
//
//    }

    @GetMapping("/getDay")
    public DayOfWeek getDay(){
        return calenderService.getTodayDate().getDayOfWeek();
    }

}
