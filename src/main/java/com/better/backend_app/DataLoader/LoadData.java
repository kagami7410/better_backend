package com.better.backend_app.DataLoader;

import com.better.backend_app.models.Activity;
import com.better.backend_app.models.ActivityDate;
import com.better.backend_app.models.LeisureCentre;
import com.better.backend_app.repositories.ActivityDateRepository;
import com.better.backend_app.repositories.ActivityRepository;
import com.better.backend_app.repositories.LeisureCentreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoadData {
    @Autowired
    LeisureCentreRepository leisureCentreRepository;
    @Autowired
    ActivityRepository activityRepository;
    @Autowired
    ActivityDateRepository activityDateRepository;

    LeisureCentre leisureCentre = new LeisureCentre();

}
