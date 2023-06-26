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
    public List<ActivityDate> createActivityDates(){
        ActivityDate activityDate1 =  new ActivityDate();
        activityDate1.setDate(LocalDate.now());
        ActivityDate activityDate2 =  new ActivityDate();
        activityDate2.setDate(LocalDate.now().plusDays(1));
        ActivityDate activityDate3 =  new ActivityDate();
        activityDate3.setDate(LocalDate.now().plusDays(2));
        ActivityDate activityDate4 =  new ActivityDate();
        activityDate4.setDate(LocalDate.now().plusDays(3));
        ActivityDate activityDate5 =  new ActivityDate();
        activityDate5.setDate(LocalDate.now().plusDays(4));
        ActivityDate activityDate6 =  new ActivityDate();
        activityDate6.setDate(LocalDate.now().plusDays(5));
        ActivityDate activityDate7 =  new ActivityDate();
        activityDate7.setDate(LocalDate.now().plusDays(6));

//        ActivityDate activityDate3 =  new ActivityDate();
//        ActivityDate activityDate4 =  new ActivityDate();
//        ActivityDate activityDate5 =  new ActivityDate();
//        ActivityDate activityDate6 =  new ActivityDate();
//        ActivityDate activityDate7 =  new ActivityDate();
//        return Arrays.asList(activityDate1, activityDate2, activityDate3, activityDate4, activityDate5, activityDate6, activityDate7);
        return Arrays.asList(activityDate1, activityDate2, activityDate3, activityDate4, activityDate5, activityDate6, activityDate7);


    }
//    @Bean
//    @Qualifier("ActivityDate2")
//    public ActivityDate createActivityDate2(){
//        ActivityDate activityDate =  new ActivityDate();
//        activityDate.setDate(LocalDate.now().plusDays(1));
//        return activityDate;
//    }
//    @Bean
//    @Qualifier("ActivityDate3")
//    public ActivityDate createActivityDate3(){
//        ActivityDate activityDate =  new ActivityDate();
//        activityDate.setDate(LocalDate.now().plusDays(2));
//        return new ActivityDate();
//    }
//    @Bean
//    @Qualifier("ActivityDate4")
//    public ActivityDate createActivityDate4(){
//        ActivityDate activityDate =  new ActivityDate();
//        activityDate.setDate(LocalDate.now().plusDays(3));
//        return new ActivityDate();
//    }
//    @Bean
//    @Qualifier("ActivityDate5")
//    public ActivityDate createActivityDate5(){
//        ActivityDate activityDate =  new ActivityDate();
//        activityDate.setDate(LocalDate.now().plusDays(4));
//        return new ActivityDate();
//    }
//    @Bean
//    @Qualifier("ActivityDate6")
//    public ActivityDate createActivityDate6(){
//        ActivityDate activityDate =  new ActivityDate();
//        activityDate.setDate(LocalDate.now().plusDays(5));
//        return new ActivityDate();
//    }
//    @Bean
//    @Qualifier("ActivityDate7")
//    public ActivityDate createActivityDate7(){
//        ActivityDate activityDate =  new ActivityDate();
//        activityDate.setDate(LocalDate.now().plusDays(6));
//        return new ActivityDate();
//    }

}
