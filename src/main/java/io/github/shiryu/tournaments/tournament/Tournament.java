package io.github.shiryu.tournaments.tournament;

import com.google.common.collect.Lists;
import io.github.shiryu.tournaments.environment.control.Controller;
import io.github.shiryu.tournaments.tournament.info.TournamentInfo;
import io.github.shiryu.tournaments.tournament.type.TournamentType;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.*;

@Getter
@Setter
public class Tournament {

    private final UUID uuid;
    private final TournamentType type;

    private final TournamentSettings settings;

    private final List<TournamentInfo> info = Lists.newLinkedList();

    public Tournament(@NotNull final TournamentType type){
        this.uuid = UUID.randomUUID();
        this.type = type;

        this.settings = new TournamentSettings(this);
    }

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
