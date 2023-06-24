package com.better.backend_app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "activitydates")
@Getter
@Setter
public class ActivityDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    LocalDate date;

    @OneToMany(mappedBy = "activityDate")
    @JsonIgnoreProperties({"activityDate"})
    private List<TimeSlot> timeSlots;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    @JsonIgnoreProperties
    private Activity activity;

    public ActivityDate() {

    }

}
