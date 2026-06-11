package com.duell.wrappedfy.domain.user;

import lombok.Getter;
import lombok.Builder;

import java.util.UUID;
import java.time.Instant;

import com.duell.wrappedfy.domain.spotify.SpotifyUserProfile;

@Getter
public class User {

    private final UUID id;
    private SpotifyUserProfile spotifyUserProfile;
    private final Instant createdAt;
    private Instant updatedAt;

    @Builder
    private User(
            UUID id,
            SpotifyUserProfile spotifyUserProfile,
            Instant createdAt,
            Instant updatedAt
    ) {
        this.id = id;
        this.spotifyUserProfile = spotifyUserProfile;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static User create(SpotifyUserProfile spotifyUserProfile) {

        Instant now = Instant.now();

        return User.builder()
                .id(UUID.randomUUID())
                .spotifyUserProfile(spotifyUserProfile)
                .createdAt(now)
                .updatedAt(now)
                .build();
    }

    public void synchronizeSpotifyProfile(SpotifyUserProfile spotifyUserProfile) {
        this.spotifyUserProfile = spotifyUserProfile;
        this.updatedAt = Instant.now();
    }

    public boolean hasSpotifyId(String spotifyId) {
        return spotifyUserProfile.spotifyId().equals(spotifyId);
    }
}