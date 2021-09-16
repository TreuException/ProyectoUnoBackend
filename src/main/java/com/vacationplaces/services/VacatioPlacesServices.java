package com.vacationplaces.services;

import com.vacationplaces.crud.CommentsRepository;
import com.vacationplaces.crud.PlacesRepository;
import com.vacationplaces.crud.PlacesTypeRepository;
import com.vacationplaces.entity.jpa.Comments;
import com.vacationplaces.entity.jpa.Places;
import com.vacationplaces.entity.jpa.PlacesType;
import com.vacationplaces.entity.request.SaveNewCommentsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import static java.nio.file.StandardOpenOption.CREATE_NEW;

@Service
@Transactional
public class VacatioPlacesServices {

    @Autowired
    PlacesTypeRepository placesTypeRepository;

    @Autowired
    PlacesRepository placesRepository;

    @Autowired
    CommentsRepository commentsRepository;

    @Autowired
    EntityManager entityManager;

    public List<PlacesType> getListTypePlaces() {
        List<PlacesType> list = placesTypeRepository.findAll();
        return list;
    }


    public List<Places> getListAllPlaces() {
        return placesRepository.findAll();
    }

    public Places getPlacesById(int id) {
        return placesRepository.findById(id).orElse(null);
        //return null;
    }

    public List<Places> listPlacesByTypeId(int id) {
        return placesRepository.findByPlacesTypeId(id);
    }


    public List<Comments> getCommentsByIdPlaces(int id) {
        return commentsRepository.findByPlacesId(id);
    }

    public boolean saveNewComments(SaveNewCommentsRequest saveNewCommentsRequest) {

        try {

            Comments comments = new Comments();
            comments.setComment(saveNewCommentsRequest.getComment());


            Places places = entityManager.getReference(Places.class, saveNewCommentsRequest.getIdPlaces());
            comments.setPlaces(places);
            comments.setName(saveNewCommentsRequest.getName());
            comments.setPhoto(
                    this.saveNewFile(saveNewCommentsRequest.getPhoto(),
                            saveNewCommentsRequest.getIdPlaces()
                    ));

            entityManager.persist(comments);

            System.out.print(comments.getId());

        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public String saveNewFile(MultipartFile file, Integer idPlaces) {

        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();

        String path = "C:\\servidor_web\\apache-tomcat-8.5.70\\webapps\\files\\photos\\";
        //String path = "/var/www/html/files/photos/";

        String fileName = "IDP-" + idPlaces + "-" + randomUUIDString + "-" + file.getOriginalFilename();

        String fileFinalPath = path + fileName;


        System.out.println(fileFinalPath);

        Path filepath = Paths.get(fileFinalPath);

        try (OutputStream os = Files.newOutputStream(filepath, CREATE_NEW)) {
            os.write(file.getBytes());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return fileFinalPath;
    }
}
