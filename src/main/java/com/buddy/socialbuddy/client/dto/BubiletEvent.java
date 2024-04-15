package com.buddy.socialbuddy.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BubiletEvent(
    @JsonProperty("etkinlikAdi") String eventName,
    @JsonProperty("slug") String slug,
    @JsonProperty("dosyalar") List<BubiletFile> bubiletFiles,
    @JsonProperty("sira") int order,
    @JsonProperty("sanatcilar") List<Integer> artists,
    @JsonProperty("mekanlar") List<Integer> venues,
    @JsonProperty("seanslar") List<BubiletSession> bubiletSessions,
    @JsonProperty("etkinlikId") int eventId,
    @JsonProperty("tumSehirlerdeGoster") boolean showInAllCities,
    @JsonProperty("seansIdler") List<Integer> sessionIds,
    @JsonProperty("toplamKalanBilet") int totalRemainingTickets,
    @JsonProperty("toplamSatilanBilet") int totalSoldTickets,
    @JsonProperty("etkinlikTarihi") String eventDate,
    @JsonProperty("etkinligeKalanGun") int daysUntilEvent,
    @JsonProperty("promoteOnly") boolean promoteOnly,
    @JsonProperty("seanslar") List<BubiletEventSession> bubiletEventSessions) {}
