package com.buddy.socialbuddy.repository;

import com.buddy.socialbuddy.domain.Event;
import com.buddy.socialbuddy.exception.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {

  default void existsByIdOrThrow(String id) {
    boolean exists = existsById(id);
    if (!exists) throw new EntityNotFoundException();
  }

  @Query("{ 'cityId': ?0, 'eventDate': { $gte: ?1 } , 'isDeleted': false}")
  List<Event> findALlUpcomingEventsByCity(Integer plateNumber, LocalDateTime time, Pageable page);

  @Query("{ '': ?0, 'eventDate': { $gte: ?1 } , 'isDeleted': false ,  masterCategoryId: ?3}")
  List<Event> findALlUpcomingEventsByCityAndMasterCategory(
      String cityName, LocalDateTime time, String categoryId);

  @Query("{ 'location': ?0, 'eventDate': { $gte: ?1 } , 'isDeleted': false ,  categoryId: ?3}")
  List<Event> findALlUpcomingEventsByCityAndSubCategory(
      String cityName, LocalDateTime time, String categoryId);

  @Query("{ 'id': ?0 }")
  @Update("{ '$set' : { 'deletedAt' : LocalDateTime.now() , 'isDeleted': true } }")
  void softDeleteById(String eventId);

  List<Event> findAllByCityId(Integer cityId);
}
