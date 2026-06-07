package com.duell.wrappedfy.application.domain.wrapped;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TopTrack {

    private final String spotifyId;
    private final String name;
    private final String artistName;
    private final String imageUrl;
}