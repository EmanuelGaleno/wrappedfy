package com.duell.wrappedfy.infrastructure.spotify;

import com.duell.wrappedfy.domain.spotify.SpotifyUserProfile;
import com.duell.wrappedfy.application.gateway.SpotifyProfileGateway;
import com.duell.wrappedfy.infrastructure.spotify.dto.SpotifyProfileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@RequiredArgsConstructor
public class SpotifyProfileGatewayImpl implements SpotifyProfileGateway {

    private final RestClient spotifyRestClient;

    @Override
    public SpotifyUserProfile getProfile(String accessToken) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private SpotifyUserProfile toDomain(SpotifyProfileResponse response) {
        return new SpotifyUserProfile(
                response.getId(),
                response.getDisplay_name(),
                response.getEmail(),
                response.getCountry(),
                null
        );
    }
}