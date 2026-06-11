package com.duell.wrappedfy.domain.wrapped;

import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

@Getter
public class Wrapped {

    private final UUID id;
    private final UUID userId;
    private final WrappedPeriod period;
    private final Instant generatedAt;
    private final WrappedSummary summary;

    @Builder
    private Wrapped(
            UUID id,
            UUID userId,
            WrappedPeriod period,
            Instant generatedAt,
            WrappedSummary summary
    ) {
        this.id = id;
        this.userId = userId;
        this.period = period;
        this.generatedAt = generatedAt;
        this.summary = summary;
    }
}