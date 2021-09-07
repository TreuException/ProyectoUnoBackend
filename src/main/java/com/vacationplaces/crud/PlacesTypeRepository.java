package com.vacationplaces.crud;

import com.vacationplaces.entity.jpa.PlacesType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlacesTypeRepository extends CrudRepository<PlacesType, Integer> {

    @Override
    List<PlacesType> findAll();
}