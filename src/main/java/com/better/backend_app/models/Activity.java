package com.better.backend_app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


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

    @OneToMany(mappedBy = "activity")
    @JsonIgnoreProperties({"activity"})
    List<ActivityDate> activityDates;


}
