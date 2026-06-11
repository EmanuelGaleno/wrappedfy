package com.duell.wrappedfy.infrastructure.spotify;

import com.duell.wrappedfy.domain.spotify.SpotifyToken;
import com.duell.wrappedfy.application.gateway.SpotifyAuthGateway;
import com.duell.wrappedfy.infrastructure.spotify.config.SpotifyProperties;
import com.duell.wrappedfy.infrastructure.spotify.dto.SpotifyTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class SpotifyAuthGatewayImpl implements SpotifyAuthGateway {

    private final RestClient spotifyRestClient;
    private final SpotifyProperties spotifyProperties;

    @Override
    public SpotifyToken exchangeCodeForToken(String authorizationCode) {

        MultiValueMap<String, String> body =
                new LinkedMultiValueMap<>();

        body.add("grant_type", "authorization_code");
        body.add("code", authorizationCode);
        body.add("redirect_uri", spotifyProperties.redirectUri());
        body.add("client_id", spotifyProperties.clientId());
        body.add("client_secret", spotifyProperties.clientSecret());

        SpotifyTokenResponse response =
                spotifyRestClient
                        .post()
                        .uri("https://accounts.spotify.com/api/token")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .body(body)
                        .retrieve()
                        .body(SpotifyTokenResponse.class);

        return toDomain(
                Objects.requireNonNull(
                        response,
                        "Spotify returned a null token response"
                )
        );
    }

    private SpotifyToken toDomain(SpotifyTokenResponse response) {

        return SpotifyToken.builder()
                .accessToken(response.getAccessToken())
                .tokenType(response.getTokenType())
                .refreshToken(response.getRefreshToken())
                .expiresIn(response.getExpiresIn())
                .build();
    }
}
