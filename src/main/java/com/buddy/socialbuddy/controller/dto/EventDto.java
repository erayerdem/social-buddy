package com.buddy.socialbuddy.controller.dto;

import com.buddy.socialbuddy.domain.EventPoster;
import java.time.LocalDateTime;
import java.util.List;

public record EventDto(
    String id,
    String name,
    LocalDateTime eventDate,
    List<EventPoster> posters,
    String type,
    String location) {}
