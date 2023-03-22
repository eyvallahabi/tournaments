package io.github.shiryu.tournaments.model;

import io.github.shiryu.tournaments.model.type.TournamentType;
import io.github.shiryu.tournaments.player.TournamentInfo;
import io.github.shiryu.tournaments.player.TournamentPlayer;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Getter
public class Tournament {

    private final TournamentType type;
    private final UUID uuid;

    public Tournament(@NotNull final TournamentType type){
        this.type = type;

        this.uuid = UUID.randomUUID();
    }

    private final List<TournamentPlayer> players = new ArrayList<>();

    @NotNull
    public Optional<TournamentPlayer> find(@NotNull final UUID uuid){
        return this.players.stream()
                .filter(player -> player.getUuid().equals(uuid))
                .findFirst();
    }

    @NotNull
    public Optional<TournamentPlayer> find(@NotNull final Player player){
        return this.find(
                player.getUniqueId()
        );
    }
}
