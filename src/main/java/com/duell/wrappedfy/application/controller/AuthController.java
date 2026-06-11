package com.duell.wrappedfy.application.controller;

import com.duell.wrappedfy.application.controller.docs.AuthApi;
import com.duell.wrappedfy.application.gateway.SpotifyAuthGateway;
import com.duell.wrappedfy.domain.spotify.SpotifyToken;
import com.duell.wrappedfy.infrastructure.spotify.config.SpotifyProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@RestController
@RequestMapping("/api/auth/spotify")
@RequiredArgsConstructor
public class AuthController implements AuthApi {

    private final SpotifyProperties spotifyProperties;
    private final SpotifyAuthGateway spotifyAuthGateway;

    @Override
    @GetMapping("/login")
    public ResponseEntity<Void> login() {

        String url = UriComponentsBuilder
                .fromUriString("https://accounts.spotify.com/authorize")
                .queryParam("client_id", spotifyProperties.clientId())
                .queryParam("response_type", "code")
                .queryParam("redirect_uri", spotifyProperties.redirectUri())
                .queryParam("scope", "user-read-email user-top-read")
                .encode()
                .toUriString();

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create(url))
                .build();
    }

    @GetMapping("/callback")
    public ResponseEntity<SpotifyToken> callback(
            @RequestParam("code") String code
    ) {

        SpotifyToken token =
                spotifyAuthGateway.exchangeCodeForToken(code);

        return ResponseEntity.ok(token);
    }
}