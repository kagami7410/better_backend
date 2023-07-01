package com.better.backend_app.service;

import com.better.backend_app.models.Activity;
import com.better.backend_app.models.ActivityDate;
import com.better.backend_app.repositories.ActivityDateRepository;
import com.better.backend_app.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.*;
import java.time.temporal.Temporal;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
@EnableScheduling
public class SchedulerService {
    @Autowired
    ActivityDateRepository activityDateRepository;

    @Autowired
    ActivityRepository activityRepository;

//    @Scheduled(cron = "0 0 23 * * ?")
//    public void scheduleDateUpdate(){
//        System.out.println("Scheduled job: " + " Current Time: " + LocalTime.now());
//    }

    @Scheduled(cron = "1 * * * * ? ")
    public void updateActivityBookingDates(){
        List<ActivityDate> activityDates = activityDateRepository.findAll();
        List<Activity> activities = activityRepository.findAll();
        System.out.println("-------------------testing------------------");

//        System.out.println("activity dates: " + activities.get(0).getActivityDates().peek().getDate());

        activities.stream()
                        .forEach(activity -> {
                            Queue<ActivityDate> activityDatesList = activity.getActivityDates();
                            ActivityDate activityDateToBeDeleted = activityDatesList.peek();
                            System.out.println("ACTIVITY TO BE DELETED: " + activityDateToBeDeleted.getDate());
                            if(activityDateToBeDeleted.getDate().equals(LocalDate.now())){
                                activityDateRepository.delete(activityDateToBeDeleted);
                                System.out.println("Booking removed for removed: "+ activityDateToBeDeleted.getDate() + activity.getName());
                            }

                        });




//
//        activityDateList.stream()
//                        .forEach(activityDate -> {
//                            System.out.println("------------- Date " + activityDate.getDate() + "-----------");
//                        });
//        activityDates.stream()
//                .forEach(activityDate -> {
//                    activityDate.setDate(activityDate.getDate().plusDays(1));
//                    System.out.println("ACTIVITY TO BE DELETED: " + activityDate.getDate());
//                    activityDateRepository.save(activityDate);
//
//                });
        }

}
