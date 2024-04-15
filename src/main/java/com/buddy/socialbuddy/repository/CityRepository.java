package com.buddy.socialbuddy.repository;

import com.buddy.socialbuddy.domain.City;
import com.buddy.socialbuddy.exception.EntityNotFoundException;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends MongoRepository<City, String> {

    default City findByIdOrThrow(String id)  {
         return findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
