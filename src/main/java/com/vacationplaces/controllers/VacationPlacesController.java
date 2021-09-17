package com.vacationplaces.controllers;

import com.vacationplaces.entity.jpa.Comments;
import com.vacationplaces.entity.jpa.Places;
import com.vacationplaces.entity.jpa.PlacesType;
import com.vacationplaces.entity.request.SaveNewCommentsRequest;
import com.vacationplaces.services.VacatioPlacesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
public class VacationPlacesController {

    @Autowired
    VacatioPlacesServices vacatioPlacesServices;

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/listAllTypePlaces")
    public List<PlacesType> getListTypePlaces() {
        List<PlacesType> list = vacatioPlacesServices.getListTypePlaces();
        return list;
    }

    @GetMapping("/listAllPlaces")
    public List<Places> getListPlaces() {
        List<Places> list = vacatioPlacesServices.getListAllPlaces();
        return list;
    }


    @GetMapping("/getPlaceById/{id}")
    public Places getPlacesById(@PathVariable int id) {
        return vacatioPlacesServices.getPlacesById(id);
    }

    @GetMapping("/listPlacesByTypeId/{id}")
    public List<Places> getPlacesByTypeId(@PathVariable int id) {
        List<Places> list = vacatioPlacesServices.listPlacesByTypeId(id);
        return list;
    }

    @GetMapping("/listCommentsByPlaces/{id}")
    public List<Comments> getCommentsByIdPlaces(@PathVariable int id) {
        List<Comments> list = vacatioPlacesServices.getCommentsByIdPlaces(id);
        return list;
    }

    /*
    //@PostMapping(value = "saveNewComments", consumes = M)
    @RequestMapping(
            consumes = { "multipart/form-data" },
            method = RequestMethod.POST,
            value = "saveNewComments")
    public boolean saveNewComments(@RequestParam("name") String name,
                                   @RequestParam("comment") String comment,
                                   @RequestParam("idPlaces") String idplaces,
                                   @RequestParam("photo") MultipartFile file
    ) {

        SaveNewCommentsRequest saveNewCommentsRequest = new SaveNewCommentsRequest();

        saveNewCommentsRequest.setComment(comment);
        saveNewCommentsRequest.setIdPlaces(Integer.parseInt(idplaces));
        saveNewCommentsRequest.setName(name);
        saveNewCommentsRequest.setPhoto(file);

        boolean result = vacatioPlacesServices.saveNewComments(saveNewCommentsRequest);

        return result;
    }

     */

    @RequestMapping(value = "/saveNewComments", method = RequestMethod.POST)
    @ResponseBody
    public boolean formulario(
            @RequestParam("name") String name,
            @RequestParam("comment") String comment,
            @RequestParam("idPlaces") String idplaces,
            @RequestParam("photo") Optional <MultipartFile> file) {

        SaveNewCommentsRequest saveNewCommentsRequest = new SaveNewCommentsRequest();

        saveNewCommentsRequest.setComment(comment);
        saveNewCommentsRequest.setIdPlaces(Integer.parseInt(idplaces));
        saveNewCommentsRequest.setName(name);
        saveNewCommentsRequest.setPhoto(file.isPresent() ? file.get(): null);

        boolean result = vacatioPlacesServices.saveNewComments(saveNewCommentsRequest);

        //vacatioPlacesServices.saveNewFile(file, 1);
        return result;
    }
}
