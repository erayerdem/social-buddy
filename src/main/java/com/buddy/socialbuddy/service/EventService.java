package com.buddy.socialbuddy.service;

import com.buddy.socialbuddy.base.dto.PageableResponse;
import com.buddy.socialbuddy.controller.dto.EventDto;
import com.buddy.socialbuddy.domain.Category;
import com.buddy.socialbuddy.domain.Event;
import com.buddy.socialbuddy.mapper.EventMapper;
import com.buddy.socialbuddy.repository.EventRepository;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

  public PageableResponse<EventDto> getAllEvents(int page, int size) {
    Pageable pageable = Pageable.ofSize(size).withPage(page - 1);
    Page<Event> all = eventRepository.findAll(pageable);
    return PageableResponse.<EventDto>builder()
        .page(page)
        .per_page(size)
        .count(all.getTotalElements())
        .data(all.stream().map(eventMapper::toDto).toList())
        .build();
  }

  public PageableResponse<EventDto> getOnComingEventsByCity(
      String cityId, @Positive Integer page, @Min(1) @Max(100) Integer per_page) {
    int plateNumber = cityService.findById(cityId).getPlateNumber();
    List<Event> events =
        eventRepository.findALlUpcomingEventsByCity(
            plateNumber, LocalDateTime.now(), Pageable.ofSize(per_page).withPage(page - 1));

    return PageableResponse.<EventDto>builder()
        .page(page)
        .per_page(per_page)
        .count(events.size())
        .data(events.stream().map(eventMapper::toDto).toList())
        .build();
  }

  public List<Event> getOnComingEventsByCityAndCategory(String cityId, String categoryId) {
    String cityName = cityService.findById(cityId).getName();
    Category category = categoryService.findById(categoryId);
    return null;
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
