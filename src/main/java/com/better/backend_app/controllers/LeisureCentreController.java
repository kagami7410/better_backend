package com.better.backend_app.controllers;

import com.better.backend_app.models.LeisureCentre;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LeisureCentreController {
    @GetMapping("leisureCentres/getAll")
    public List<LeisureCentre> getLeisureCentre(){

    }
}
