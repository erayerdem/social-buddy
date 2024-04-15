package com.buddy.socialbuddy.mapper;

import com.buddy.socialbuddy.base.BaseMapper;
import com.buddy.socialbuddy.client.dto.BubiletEvent;
import com.buddy.socialbuddy.controller.dto.EventDto;
import com.buddy.socialbuddy.domain.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface EventMapper extends BaseMapper<Event, EventDto> {

  @Mapping(source = "eventName", target = "name")
  @Mapping(source = "bubiletFiles", target = "files")
  @Mapping(source = "eventId", target = "externalId")
  Event toEntity(BubiletEvent dto);

  @Mapping(source = "eventName", target = "name")
  @Mapping(source = "bubiletFiles", target = "files")
  @Mapping(source = "eventId", target = "externalId")
  Event update(@MappingTarget Event entity, BubiletEvent updateEntity);

  default Event toEntityWithCityId(BubiletEvent dto, Integer cityId) {
    Event event = toEntity(dto);
    event.setCityId(cityId);
    return event;
  }
}
