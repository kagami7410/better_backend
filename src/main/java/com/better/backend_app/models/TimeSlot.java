package com.better.backend_app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
@Getter
@Setter
@Entity
@Table(name = "timeSlots")
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Time timeSlot;

    @ManyToOne
    @JoinColumn(name = "activityDate_id")
    @JsonIgnoreProperties()
    private ActivityDate activityDate;
}
