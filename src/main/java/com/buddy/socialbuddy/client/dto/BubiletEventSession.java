package com.buddy.socialbuddy.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

public record BubiletEventSession(
    @JsonProperty("etkinlikId") Integer eventId,
    @JsonProperty("seansGizle") Boolean hideSession,
    @JsonProperty("mekanId") Integer venueId,
    @JsonProperty("tarih") OffsetDateTime date,
    @JsonProperty("kalanBilet") Integer remainingTickets,
    @JsonProperty("fiyat") Double price,
    @JsonProperty("promoteOnly") Boolean promoteOnly,
    @JsonProperty("indirimliFiyat") Double discountedPrice,
    @JsonProperty("etkinligeKalanGun") Integer daysUntilEvent,
    @JsonProperty("satilanBilet") Integer soldTickets,
    @JsonProperty("seansId") Integer sessionId,
    @JsonProperty("koltukSecimi") Boolean seatSelection,
    @JsonProperty("yardimEtkinlik") Boolean helpEvent) {}
