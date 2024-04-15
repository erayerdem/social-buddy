package com.buddy.socialbuddy.client;

import com.buddy.socialbuddy.client.dto.BubiletArtist;
import com.buddy.socialbuddy.client.dto.BubiletEvent;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

public interface BubiletClient {

  @PostExchange("/Sanatci/SanatcilariGetir")
  List<BubiletArtist> getArtists(@RequestBody List<Integer> ids);

  @GetExchange("/Anasayfa/6/Etkinlikler")
  List<BubiletEvent> getEvents(@RequestHeader(value = "ilid") Integer countryId);
}
