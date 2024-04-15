package com.buddy.socialbuddy.controller;

import com.buddy.socialbuddy.base.dto.ApiResponse;
import com.buddy.socialbuddy.controller.dto.EventDto;
import com.buddy.socialbuddy.domain.Event;
import com.buddy.socialbuddy.mapper.EventMapper;
import com.buddy.socialbuddy.service.EventService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("events")
@Slf4j
public class EventController {

    private final EventService eventService;
    private final EventMapper eventMapper;

  @GetMapping
  public ApiResponse<List<EventDto>> getAllEvents() {
        log.info("Getting all events");
        List<Event> allEvents = eventService.getAllEvents();
        log.info("Got all events successfully");
    return ApiResponse.<List<EventDto>>builder().data(eventMapper.toDtos(allEvents)).build();
    }

  @DeleteMapping("{id}")
  public ApiResponse<Void> softDeleteById(@PathVariable("id") String id) {
        eventService.softDeleteById(id);
    return ApiResponse.<Void>builder().build();
    }

  @GetMapping("cities/{cityId}")
  public ApiResponse<List<EventDto>> onComingEventsByCity(@PathVariable String cityId) {
        List<Event> events = eventService.getOnComingEventsByCity(cityId);

    return ApiResponse.<List<EventDto>>builder().data(eventMapper.toDtos(events)).build();
    }

  @GetMapping("cities/{cityId}/categories/{categoryId}")
  public ApiResponse<List<EventDto>> onComingEventsByCityAndCategory(
      @PathVariable String cityId, @PathVariable String categoryId) {

        List<Event> events = eventService.getOnComingEventsByCityAndCategory(cityId, categoryId);

    return ApiResponse.<List<EventDto>>builder().data(eventMapper.toDtos(events)).build();
    }
}
