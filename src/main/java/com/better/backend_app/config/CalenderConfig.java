package com.better.backend_app.config;

import com.better.backend_app.models.ActivityDate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class CalenderConfig {
    @Bean
    public ActivityDate createActivityDate(){
        return new ActivityDate();
    }
}
