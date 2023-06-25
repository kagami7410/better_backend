package com.better.backend_app.service;

import com.better.backend_app.models.ActivityDate;
import com.better.backend_app.repositories.ActivityDateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CalenderService {
    @Autowired
    ActivityDateRepository activityDateRepository;
    public ActivityDate activityDate;


    public void addDates(){

        LocalDate dateToday = LocalDate.now();

        LocalDate dateLater = dateToday.plusDays(7);

        long numOfDays = ChronoUnit.DAYS.between(dateToday, dateLater);

        List<LocalDate> listOfDates = Stream.iterate(dateToday, date -> date.plusDays(1))
                .limit(numOfDays)
                .collect(Collectors.toList());

    }


    public LocalDateTime getTodayDate(){
        return LocalDateTime.now();
    }

}
