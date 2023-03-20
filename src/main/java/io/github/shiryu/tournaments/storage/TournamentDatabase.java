package io.github.shiryu.tournaments.storage;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import io.github.shiryu.tournaments.model.Tournament;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.Optional;
import java.util.UUID;

@Getter
public abstract class TournamentDatabase {

    private final Cache<UUID, Optional<Tournament>> tournaments = Caffeine.newBuilder()
            .maximumSize(100)
            .expireAfterWrite(Duration.ofMinutes(10))
            .build(this::load);


    @NotNull
    public abstract Optional<Tournament> load(@NotNull final UUID uuid);
}
