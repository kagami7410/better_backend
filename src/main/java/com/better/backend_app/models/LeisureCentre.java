package com.better.backend_app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
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

    @OneToMany(mappedBy = "leisureCentre",cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties({"leisureCentre"})
    private List<Activity> activities;

    public LeisureCentre() {
    }
}
