package com.vacationplaces.entity.jpa;

import javax.persistence.*;

@Entity
@Table(name = "places_type")
public class PlacesType {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
