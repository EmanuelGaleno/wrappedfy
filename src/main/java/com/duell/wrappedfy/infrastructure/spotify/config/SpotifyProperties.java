package com.duell.wrappedfy.infrastructure.spotify.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spotify")
public record SpotifyProperties(
        String clientId,
        String clientSecret,
        String redirectUri
) {
}