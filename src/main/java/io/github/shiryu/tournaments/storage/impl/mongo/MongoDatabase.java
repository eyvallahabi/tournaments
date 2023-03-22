package io.github.shiryu.tournaments.storage.impl.mongo;

import io.github.shiryu.tournaments.model.Tournament;
import io.github.shiryu.tournaments.player.TournamentPlayer;
import io.github.shiryu.tournaments.storage.TournamentDatabase;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.UUID;

public class MongoDatabase extends TournamentDatabase {

    @Override
    public @NotNull Optional<TournamentPlayer> load(@NotNull UUID uuid) {
        return Optional.empty();
    }

}
