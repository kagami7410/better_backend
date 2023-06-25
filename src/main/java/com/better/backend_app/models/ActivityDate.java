package com.better.backend_app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
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

    @Column
    DayOfWeek dayOfWeek;

    @OneToMany(mappedBy = "activityDate")
    @JsonIgnoreProperties({"activityDate"})
    private List<TimeSlot> timeSlots;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    @JsonIgnoreProperties
    private Activity activity;


    public ActivityDate() {

    }

    public void setDate() {
        this.date = LocalDate.now();
    }

    public void setDayOfWeek(LocalDate localDate) {
        localDate.getDayOfWeek();
    }

    @Override
    public String toString() {
        return "ActivityDate{" +
                "id=" + id +
                ", date=" + date +
                ", dayOfWeek=" + dayOfWeek +
                ", timeSlots=" + timeSlots +
                ", activity=" + activity +
                '}';
    }
}
