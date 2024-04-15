package com.buddy.socialbuddy.service;

import com.buddy.socialbuddy.domain.Category;
import com.buddy.socialbuddy.domain.Event;
import com.buddy.socialbuddy.mapper.EventMapper;
import com.buddy.socialbuddy.repository.EventRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventService {

  private final EventRepository eventRepository;
  private final CityService cityService;
  private final CategoryService categoryService;
  private final BuBiletService buBiletService;
  private final EventMapper eventMapper;

  public void softDeleteById(String id) {
    eventRepository.existsByIdOrThrow(id);
    eventRepository.softDeleteById(id);
  }

  public List<Event> getAllEvents() {
    return eventRepository.findAll();
  }

  public List<Event> getOnComingEventsByCity(String cityId) {
    String cityName = cityService.findById(cityId).getName();
    return eventRepository.findALlUpcomingEventsByCity(cityName, LocalDateTime.now());
  }

  public List<Event> getOnComingEventsByCityAndCategory(String cityId, String categoryId) {
    String cityName = cityService.findById(cityId).getName();
    Category category = categoryService.findById(categoryId);
    return category.isMasterCategory()
        ? eventRepository.findALlUpcomingEventsByCityAndMasterCategory(
            cityName, LocalDateTime.now(), categoryId)
        : eventRepository.findALlUpcomingEventsByCityAndSubCategory(
            cityName, LocalDateTime.now(), categoryId);
  }

  public List<Event> updateAllEvents() {
    return IntStream.rangeClosed(1, 81)
        .boxed()
        .flatMap(
            cityId -> {
              List<Event> events = eventRepository.findAllByCityId(cityId);
              return buBiletService.getEvents(cityId).stream()
                  .map(
                      event ->
                          events.stream()
                              .filter(e -> event.eventId() == e.getExternalId())
                              .findFirst()
                              .map(e -> eventMapper.update(e, event))
                              .orElseGet(() -> eventMapper.toEntityWithCityId(event, cityId)));
            })
        .map(eventRepository::save)
        .toList();
  }
}
