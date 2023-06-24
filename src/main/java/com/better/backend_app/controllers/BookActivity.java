package com.better.backend_app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookActivity {
    @GetMapping("/book-activity")
    String getLeisureCentres(){
        return "centres";
    }
}
