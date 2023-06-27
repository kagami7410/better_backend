package com.better.backend_app.repositories;

import com.better.backend_app.models.Activity;
import com.better.backend_app.models.LeisureCentre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
     Activity findActivityByNameAndLeisureCentre(String name, LeisureCentre leisureCentre);
}
