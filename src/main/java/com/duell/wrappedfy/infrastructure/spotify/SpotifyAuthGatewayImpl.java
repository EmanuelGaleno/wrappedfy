package com.duell.wrappedfy.infrastructure.spotify;

import com.duell.wrappedfy.application.domain.spotify.SpotifyToken;
import com.duell.wrappedfy.application.gateway.SpotifyAuthGateway;
import com.duell.wrappedfy.infrastructure.spotify.config.SpotifyProperties;
import com.duell.wrappedfy.infrastructure.spotify.dto.SpotifyTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@RequiredArgsConstructor
public class SpotifyAuthGatewayImpl implements SpotifyAuthGateway {

    private final RestClient spotifyRestClient;
    private final SpotifyProperties spotifyProperties;

    @Override
    public SpotifyToken exchangeCodeForToken(String authorizationCode) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private SpotifyToken toDomain(SpotifyTokenResponse response) {

        return SpotifyToken.builder()
                .accessToken(response.getAccess_token())
                .refreshToken(response.getRefresh_token())
                .expiresIn(response.getExpires_in())
                .build();
    }
}
