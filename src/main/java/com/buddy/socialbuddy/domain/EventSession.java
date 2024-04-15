package com.buddy.socialbuddy.domain;

import java.time.OffsetDateTime;

public record EventSession(
    Integer eventId,
    Boolean hideSession,
    Integer venueId,
    OffsetDateTime date,
    Integer remainingTickets,
    Double price,
    Boolean promoteOnly,
    Double discountedPrice,
    Integer daysUntilEvent,
    Integer soldTickets,
    Integer sessionId,
    Boolean seatSelection,
    Boolean helpEvent) {}
