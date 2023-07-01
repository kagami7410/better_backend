package com.better.backend_app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


@Entity
@Table(name="activities")
@Getter
@Setter
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "leisureCentre_id")
    @JsonIgnoreProperties({"activities"})
    private LeisureCentre leisureCentre;

    @OneToMany(mappedBy = "activity", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"activity"})
    List<ActivityDate> activityDates;

    public void setActivityDates(Queue<ActivityDate> activityDates) {
        List<ActivityDate> activityDateList = new ArrayList<>(activityDates);
        this.activityDates = activityDateList;
    }

    public Queue<ActivityDate> getActivityDates(){
        Queue<ActivityDate> queuedActivites = new LinkedList<>(this.activityDates);
        return queuedActivites;
    }

}
