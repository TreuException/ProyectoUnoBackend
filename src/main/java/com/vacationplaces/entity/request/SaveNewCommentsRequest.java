package com.vacationplaces.entity.request;

import org.springframework.web.multipart.MultipartFile;

public class SaveNewCommentsRequest {

    private String name;
    private String comment;
    private MultipartFile photo;
    private int idPlaces;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }

    public int getIdPlaces() {
        return idPlaces;
    }

    public void setIdPlaces(int idPlaces) {
        this.idPlaces = idPlaces;
    }
}
