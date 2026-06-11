package com.duell.wrappedfy.application.repository;

import com.duell.wrappedfy.domain.wrapped.Wrapped;
import com.duell.wrappedfy.domain.wrapped.WrappedPeriod;

import java.util.Optional;
import java.util.UUID;

public interface WrappedRepository {

    Wrapped save(Wrapped wrapped);

    Optional<Wrapped> findByUserIdAndPeriod(
            UUID userId,
            WrappedPeriod period
    );
}