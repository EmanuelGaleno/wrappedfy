package com.duell.wrappedfy.application.gateway;

import com.duell.wrappedfy.domain.spotify.SpotifyToken;

public interface SpotifyAuthGateway {

    SpotifyToken exchangeCodeForToken(String authorizationCode);

}