package com.better.backend_app.repositories;

import com.better.backend_app.models.LeisureCentre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LeisureCentreRepository extends JpaRepository<LeisureCentre, Long> {

    Optional<LeisureCentre> findByName(String Name);

}
