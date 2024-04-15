package com.buddy.socialbuddy.mapper;

import com.buddy.socialbuddy.base.BaseMapper;
import com.buddy.socialbuddy.controller.dto.CityDto;
import com.buddy.socialbuddy.domain.City;
import org.mapstruct.Mapper;

@Mapper
public interface CityMapper extends BaseMapper<City, CityDto> {
}
