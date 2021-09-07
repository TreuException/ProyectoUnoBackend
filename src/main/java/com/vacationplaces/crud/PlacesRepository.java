package com.vacationplaces.crud;

import com.vacationplaces.entity.jpa.Places;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlacesRepository extends CrudRepository<Places, Integer> {

    @Override
    List<Places> findAll();

    List<Places> findByPlacesTypeId(Integer id);
}
