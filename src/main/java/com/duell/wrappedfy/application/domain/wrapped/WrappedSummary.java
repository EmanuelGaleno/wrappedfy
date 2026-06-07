package com.duell.wrappedfy.application.domain.wrapped;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class WrappedSummary {

    private final List<TopArtist> topArtists;
    private final List<TopTrack> topTracks;
    private final List<String> topGenres;
    private final Long hoursListened;
}