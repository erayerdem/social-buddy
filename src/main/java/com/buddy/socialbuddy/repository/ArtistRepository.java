package com.buddy.socialbuddy.repository;

import com.buddy.socialbuddy.domain.Artist;
import com.buddy.socialbuddy.exception.EntityNotFoundException;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends MongoRepository<Artist, String> {
  default Artist findByIdOrThrow(String id) {
    return findById(id).orElseThrow(EntityNotFoundException::new);
  }
}
