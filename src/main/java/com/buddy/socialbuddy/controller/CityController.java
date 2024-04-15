package com.buddy.socialbuddy.controller;

import com.buddy.socialbuddy.base.dto.ApiResponse;
import com.buddy.socialbuddy.controller.dto.CityDto;
import com.buddy.socialbuddy.domain.City;
import com.buddy.socialbuddy.mapper.CityMapper;
import com.buddy.socialbuddy.service.CityService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("cities")
public class CityController {

  private final CityService cityService;
  private final CityMapper cityMapper;

  @GetMapping
  public ApiResponse<List<CityDto>> getAllCities() {
    List<City> cities = cityService.getCities();

    return ApiResponse.<List<CityDto>>builder().data(cityMapper.toDtos(cities)).build();
  }
}
