package io.github.shiryu.tournaments.storage;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import io.github.shiryu.tournaments.model.Tournament;
import io.github.shiryu.tournaments.player.TournamentPlayer;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.Optional;
import java.util.UUID;

@Getter
public abstract class TournamentDatabase {

    private final Cache<UUID, Optional<TournamentPlayer>> tournaments = Caffeine.newBuilder()
            .maximumSize(100)
            .expireAfterWrite(Duration.ofMinutes(10))
            .build(this::load);


    @NotNull
    public abstract Optional<TournamentPlayer> load(@NotNull final UUID uuid);
}
