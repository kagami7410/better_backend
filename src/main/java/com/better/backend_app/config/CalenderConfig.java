package com.better.backend_app.config;

import com.better.backend_app.models.Activity;
import com.better.backend_app.models.ActivityDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.LocalDate;
import java.util.*;

@Configuration
public class CalenderConfig {
    @Bean
    public ActivityDate createActivityDates(){
        ActivityDate activityDate1 =  new ActivityDate();
        activityDate1.setDate(LocalDate.now());

        return activityDate1;


    }
    @Bean
    public ActivityDate createActivityDate2(){
        ActivityDate activityDate =  new ActivityDate();
        activityDate.setDate(LocalDate.now().plusDays(1));
        return activityDate;
    }

}
