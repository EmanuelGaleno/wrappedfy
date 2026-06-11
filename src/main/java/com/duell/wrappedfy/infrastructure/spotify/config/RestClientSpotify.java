package com.duell.wrappedfy.infrastructure.spotify.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientSpotify {

    @Bean
    public RestClient spotifyRestClient() {
        return RestClient.builder()
                .baseUrl("https://accounts.spotify.com")
                .build();
    }
}