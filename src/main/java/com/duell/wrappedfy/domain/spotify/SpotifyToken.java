package com.duell.wrappedfy.domain.spotify;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SpotifyToken {

    private final String accessToken;
    private final String tokenType;
    private final String refreshToken;
    private final Long expiresIn;
}