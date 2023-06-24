package com.better.backend_app.service;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CalenderService {
    public Date getDate(){
        long millis=System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        return date;
    }

}
