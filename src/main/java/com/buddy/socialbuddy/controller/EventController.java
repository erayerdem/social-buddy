package com.buddy.socialbuddy.controller;

import com.buddy.socialbuddy.base.dto.ApiResponse;
import com.buddy.socialbuddy.base.dto.PageableResponse;
import com.buddy.socialbuddy.controller.dto.EventDto;
import com.buddy.socialbuddy.domain.Event;
import com.buddy.socialbuddy.mapper.EventMapper;
import com.buddy.socialbuddy.service.EventService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("events")
@Slf4j
@Validated
public class EventController {

  private final EventService eventService;
  private final EventMapper eventMapper;

  @GetMapping
  public ApiResponse<PageableResponse<EventDto>> getAllEvents(
      @Positive @RequestParam(defaultValue = "1") Integer page,
      @Min(1) @Max(100) @RequestParam(defaultValue = "10") Integer per_page) {
    log.info("Getting all events");
    PageableResponse<EventDto> allEvents = eventService.getAllEvents(page, per_page);
    log.info("Got all events successfully");
    return ApiResponse.<PageableResponse<EventDto>>builder().data(allEvents).build();
  }

  @DeleteMapping("{id}")
  public ApiResponse<Void> softDeleteById(@PathVariable("id") String id) {
    eventService.softDeleteById(id);
    return ApiResponse.<Void>builder().build();
  }

  @GetMapping("cities/{cityId}")
  public ApiResponse<PageableResponse<EventDto>> onComingEventsByCity(
      @PathVariable String cityId,
      @Positive @RequestParam(defaultValue = "1") Integer page,
      @Min(1) @Max(100) @RequestParam(defaultValue = "10") Integer per_page) {
    PageableResponse<EventDto> events =
        eventService.getOnComingEventsByCity(cityId, page, per_page);
    return ApiResponse.<PageableResponse<EventDto>>builder().data(events).build();
  }

  @GetMapping("cities/{cityId}/categories/{categoryId}")
  public ApiResponse<List<EventDto>> onComingEventsByCityAndCategory(
      @PathVariable String cityId, @PathVariable String categoryId) {

    List<Event> events = eventService.getOnComingEventsByCityAndCategory(cityId, categoryId);

    return ApiResponse.<List<EventDto>>builder().data(eventMapper.toDtos(events)).build();
  }
}
