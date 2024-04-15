package com.buddy.socialbuddy.service;


import com.buddy.socialbuddy.domain.City;
import com.buddy.socialbuddy.repository.CityRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public City findById(String id) {
        return cityRepository.findByIdOrThrow(id);
    }

    public List<City> getCities() {
        return cityRepository.findAll();
    }
}
