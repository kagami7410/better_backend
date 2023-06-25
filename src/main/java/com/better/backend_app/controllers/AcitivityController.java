package com.better.backend_app.controllers;


import com.better.backend_app.service.CalenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@RestController
public class AcitivityController {
    @Autowired CalenderService calenderService;

    @GetMapping("/getDates")
    public List<LocalDate> getDates(){
        return calenderService.getDate();
    }

    @GetMapping("/getDay")
    public DayOfWeek getDay(){
        return calenderService.getTodayDate().getDayOfWeek();
    }

}
