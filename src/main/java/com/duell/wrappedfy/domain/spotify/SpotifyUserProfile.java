package com.duell.wrappedfy.domain.spotify;


public record SpotifyUserProfile(
        String spotifyId,
        String displayName,
        String email,
        String country,
        String imageUrl
) {
}
