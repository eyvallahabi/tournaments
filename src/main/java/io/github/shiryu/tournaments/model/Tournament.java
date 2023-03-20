package io.github.shiryu.tournaments.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class Tournament {

    private final UUID uuid;

    private final List<TournamentInfo> info = new ArrayList<>();

    @NotNull
    public Optional<TournamentInfo> find(@NotNull final UUID uuid){
        return this.info.stream()
                .filter(info -> info.getUuid().equals(uuid))
                .findFirst();
    }

    @NotNull
    public Optional<TournamentInfo> find(@NotNull final Player player){
        return this.find(
                player.getUniqueId()
        );
    }
}
