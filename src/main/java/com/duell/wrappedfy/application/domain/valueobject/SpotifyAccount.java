package com.duell.wrappedfy.application.domain.valueobject;


public record SpotifyAccount(
        String spotifyId,
        String displayName,
        String email,
        String country,
        String imageUrl
) {
}
