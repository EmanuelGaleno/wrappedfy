package com.duell.wrappedfy.application.repository;

import com.duell.wrappedfy.application.domain.user.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findBySpotifyId(String spotifyId);

    User save(User user);
}
