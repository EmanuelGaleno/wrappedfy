package com.duell.wrappedfy.application.domain.user;

import com.duell.wrappedfy.application.domain.valueobject.SpotifyAccount;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

@Getter
public class User {

    private final UUID id;
    private SpotifyAccount spotifyAccount;
    private final Instant createdAt;
    private Instant updatedAt;

    @Builder
    private User(
            UUID id,
            SpotifyAccount spotifyAccount,
            Instant createdAt,
            Instant updatedAt
    ) {
        this.id = id;
        this.spotifyAccount = spotifyAccount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static User create(SpotifyAccount spotifyAccount) {

        Instant now = Instant.now();

        return User.builder()
                .id(UUID.randomUUID())
                .spotifyAccount(spotifyAccount)
                .createdAt(now)
                .updatedAt(now)
                .build();
    }

    public void synchronizeSpotifyAccount(SpotifyAccount spotifyAccount) {
        this.spotifyAccount = spotifyAccount;
        this.updatedAt = Instant.now();
    }

    public boolean belongsToSpotifyAccount(String spotifyId) {
        return spotifyAccount.spotifyId().equals(spotifyId);
    }
}