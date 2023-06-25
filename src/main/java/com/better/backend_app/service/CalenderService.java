package com.better.backend_app.service;

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
    public List<LocalDate> getDate(){

        LocalDate dateToday = LocalDate.now();

        LocalDate dateLater = dateToday.plusDays(152);

        long numOfDays = 10;

        List<LocalDate> listOfDates = Stream.iterate(dateLater, date -> date.plusDays(1))
                .limit(numOfDays)
                .collect(Collectors.toList());

        return listOfDates;

    }

    public LocalDateTime getTodayDate(){
        return LocalDateTime.now();
    }

}
