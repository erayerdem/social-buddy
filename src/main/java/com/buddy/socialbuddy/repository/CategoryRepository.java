package com.buddy.socialbuddy.repository;

import com.buddy.socialbuddy.domain.Category;
import com.buddy.socialbuddy.exception.EntityNotFoundException;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
  default Category findByIdOrThrow(String id) {
    return findById(id).orElseThrow(EntityNotFoundException::new);
  }
}
