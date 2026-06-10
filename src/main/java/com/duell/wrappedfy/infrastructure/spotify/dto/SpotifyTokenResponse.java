package com.duell.wrappedfy.infrastructure.spotify.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpotifyTokenResponse {

    private String access_token;
    private String token_type;
    private Long expires_in;
    private String refresh_token;
}