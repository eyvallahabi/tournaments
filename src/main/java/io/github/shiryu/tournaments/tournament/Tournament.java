package io.github.shiryu.tournaments.tournament;

import com.google.common.collect.Lists;
import io.github.shiryu.tournaments.tournament.info.TournamentInfo;
import io.github.shiryu.tournaments.tournament.type.TournamentType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class Tournament {

    private final String id;
    private final TournamentType type;

    private final List<TournamentInfo> info = Lists.newLinkedList();

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
