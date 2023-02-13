package io.github.shiryu.tournaments.tournament;

import com.google.common.collect.Lists;
import io.github.shiryu.tournaments.tournament.info.TournamentInfo;
import io.github.shiryu.tournaments.tournament.manager.TournamentManager;
import io.github.shiryu.tournaments.tournament.manager.reward.RewardManager;
import io.github.shiryu.tournaments.tournament.type.TournamentType;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Getter
public class Tournament {

    private final String id;
    private final TournamentType type;

    private TournamentSettings settings;

    private final List<TournamentInfo> info = Lists.newLinkedList();

    public Tournament(@NotNull final String id, @NotNull final TournamentType type){
        this.id = id;
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
