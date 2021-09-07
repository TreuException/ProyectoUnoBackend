package com.vacationplaces.crud;

import com.vacationplaces.entity.jpa.Comments;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentsRepository extends CrudRepository<Comments, Integer> {

    List<Comments> findByPlacesId(Integer id);
}
