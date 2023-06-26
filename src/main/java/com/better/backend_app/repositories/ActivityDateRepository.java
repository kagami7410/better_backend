package com.better.backend_app.repositories;

import com.better.backend_app.models.ActivityDate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityDateRepository extends JpaRepository<ActivityDate, Long> {
}
