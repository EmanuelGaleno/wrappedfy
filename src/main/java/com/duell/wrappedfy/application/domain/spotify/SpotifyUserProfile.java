package com.duell.wrappedfy.application.domain.spotify;


public record SpotifyUserProfile(
        String spotifyId,
        String displayName,
        String email,
        String country,
        String imageUrl
) {
}
