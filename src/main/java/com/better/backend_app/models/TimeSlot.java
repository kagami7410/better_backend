package com.better.backend_app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Map;

@Getter
@Setter
@Entity
@Table(name = "timeSlots")
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer startTime;

    @Column
    private Integer endTime;

    @Column
    private boolean availability;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "activityDate_id")
    @JsonIgnoreProperties({ "timeSlots", "id"})
    private ActivityDate activityDate;

    @Override
    public String toString() {
        return "TimeSlot{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", availability=" + availability +
                ", activityDate=" + activityDate +
                '}';
    }
}
