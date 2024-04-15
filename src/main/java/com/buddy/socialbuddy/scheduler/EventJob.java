package com.buddy.socialbuddy.scheduler;

import com.buddy.socialbuddy.service.ArtistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableSchedulerLock(defaultLockAtMostFor = "10m", defaultLockAtLeastFor = "10m")
@RequiredArgsConstructor
@Slf4j
public class EventJob {

  private final ArtistService artistService;

  @Scheduled(cron = "0 23 00 * * ?", zone = "Europe/Istanbul")
  @SchedulerLock(name = "get_artists")
  public void run() {
    log.info("Getting artists");
    artistService.upsertAllArtists();
    log.info("Getting artists done");
  }
}
