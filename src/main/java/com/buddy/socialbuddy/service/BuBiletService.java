package com.buddy.socialbuddy.service;

import com.buddy.socialbuddy.client.BubiletClient;
import com.buddy.socialbuddy.client.dto.BubiletArtist;
import com.buddy.socialbuddy.client.dto.BubiletEvent;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuBiletService {

  private final BubiletClient bubiletClient;

  public List<BubiletArtist> getArtists(List<Integer> artistIds) {
    return bubiletClient.getArtists(artistIds);
  }

  public List<BubiletEvent> getEvents(Integer countryId) {
    return bubiletClient.getEvents(countryId);
  }
}
