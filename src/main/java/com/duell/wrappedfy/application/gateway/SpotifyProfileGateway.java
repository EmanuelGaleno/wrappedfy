package com.duell.wrappedfy.application.gateway;

import com.duell.wrappedfy.application.domain.spotify.SpotifyUserProfile;

public interface SpotifyProfileGateway {

    SpotifyUserProfile getProfile(String accessToken);

}
