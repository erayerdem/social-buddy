package com.buddy.socialbuddy.service;

import com.buddy.socialbuddy.domain.Artist;
import com.buddy.socialbuddy.mapper.ArtistMapper;
import com.buddy.socialbuddy.repository.ArtistRepository;
import java.util.List;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ArtistService {

  private final BuBiletService buBiletService;
  private final ArtistRepository artistRepository;
  private final ArtistMapper artistMapper;

  @Transactional
  public List<Artist> upsertAllArtists() {
    List<Integer> artistIds = IntStream.rangeClosed(1, 10000).boxed().toList();
    List<Artist> artists =
        buBiletService.getArtists(artistIds).stream().map(artistMapper::toEntity).toList();
    artistRepository.deleteAll();
    return artistRepository.saveAll(artists);
  }

  @Transactional
  public List<Artist> getAllArtists() {
    return artistRepository.findAll();
  }
}
