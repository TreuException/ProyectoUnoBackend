package com.vacationplaces;

import com.vacationplaces.crud.PlacesTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AplicationInit {


    public static void main(String[] args) {
        SpringApplication.run(AplicationInit.class, args);
    }
}
