package com.duell.wrappedfy.infrastructure.spotify.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpotifyProfileResponse {

    private String id;
    private String display_name;
    private String email;
    private String country;
}
