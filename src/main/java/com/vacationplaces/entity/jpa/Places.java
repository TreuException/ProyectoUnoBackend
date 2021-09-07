package com.vacationplaces.entity.jpa;

import javax.persistence.*;

@Entity
@Table(name = "places")
public class Places {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String name;

    private String location;

    @Column(name="coordinate_la")
    private int coordinateLa;

    @Column(name="coordinate_lo")
    private int coordinateLo;

    private String photo;

    private String description;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_places_type")
    private PlacesType placesType;


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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCoordinateLa() {
        return coordinateLa;
    }

    public void setCoordinateLa(int coordinateLa) {
        this.coordinateLa = coordinateLa;
    }

    public int getCoordinateLo() {
        return coordinateLo;
    }

    public void setCoordinateLo(int coordinateLo) {
        this.coordinateLo = coordinateLo;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PlacesType getPlacesType() {
        return placesType;
    }

    public void setPlacesType(PlacesType placesType) {
        this.placesType = placesType;
    }
}
