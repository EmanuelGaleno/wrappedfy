package com.duell.wrappedfy.domain.wrapped;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TopArtist {

    private final String spotifyId;
    private final String name;
    private final String imageUrl;
}