package com.better.backend_app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "leisure_centres")
public class LeisureCentre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String Location;

    @OneToMany(mappedBy = "leisureCentre")
    @JsonIgnoreProperties({"leisureCentre"})
    private List<Activity> activities;
}
