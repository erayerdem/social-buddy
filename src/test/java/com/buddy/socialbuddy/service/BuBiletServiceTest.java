package com.buddy.socialbuddy.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.buddy.socialbuddy.client.BubiletClient;
import com.buddy.socialbuddy.client.dto.BubiletArtist;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
class BuBiletServiceTest {

  @Autowired private BuBiletService buBiletService;

  @Autowired private ArtistService artistService;

  @Autowired private EventService eventService;

  @Mock private BubiletClient bubiletClient;

  private static String workingDir;

  private static ObjectMapper objectMapper;

  @BeforeAll
  public static void init() {
    workingDir = "src/test/resources/";
    objectMapper = new ObjectMapper();
  }

  @Test
  void getArtists_SuccessTest() throws IOException {

    List<Integer> artistIds = IntStream.rangeClosed(1, 10000).boxed().collect(Collectors.toList());

    List<BubiletArtist> list =
        objectMapper.readValue(new File(workingDir + "artists.json"), List.class);

    when(bubiletClient.getArtists(artistIds)).thenReturn(list);

    List<BubiletArtist> actualBubiletArtists = buBiletService.getArtists(artistIds);

    assertNotEquals(0, actualBubiletArtists.size());
  }

 /* @Test
  void getEvents_SuccessTest() throws IOException {

    Integer mersin = 33;

    List<BubiletEvent> list =
        objectMapper.readValue(new File(workingDir + "events.json"), List.class);

    when(bubiletClient.getEvents(mersin)).thenReturn(list);

    List<BubiletEvent> actualBubiletArtists = buBiletService.getEvents(mersin);

    assertEquals(29, actualBubiletArtists.size());
  } */

  @Test
  void upsertAllArtistsTest() {

    // todo add mock here

    /*List<Artist> artists = artistService.upsertAllArtists();

    assertNotEquals(0, artists.size());
    assertEquals(artists.size(), artistService.getAllArtists().size()); */
  }

  @Test
  void upsertAllEvents() {


    // todo add mock here

    /*List<Event> events = eventService.updateAllEvents();

    assertNotEquals(0, events.size());
    assertEquals(events.size(), eventService.getAllEvents().size()); */ 
  }
}
