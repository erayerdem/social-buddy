package com.buddy.socialbuddy.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BubiletSession(
        @JsonProperty("etkinlikId") int eventId,
        @JsonProperty("seansGizle") boolean hideSession,
        @JsonProperty("mekanId") int venueId,
        @JsonProperty("tarih") String date,
        @JsonProperty("kalanBilet") int remainingTickets,
        @JsonProperty("fiyat") double price,
        @JsonProperty("promoteOnly") boolean promoteOnly,
        @JsonProperty("indirimliFiyat") double discountedPrice,
        @JsonProperty("etkinligeKalanGun") int daysUntilEvent,
        @JsonProperty("satilanBilet") int soldTickets,
        @JsonProperty("seansId") int sessionId,
        @JsonProperty("koltukSecimi") boolean seatSelection,
        @JsonProperty("yardimEtkinlik") boolean helpEvent
) {}
