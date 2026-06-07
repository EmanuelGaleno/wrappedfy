package com.duell.wrappedfy.application.domain.spotify;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SpotifyToken {

    private final String accessToken;
    private final String refreshToken;
    private final Long expiresIn;
}