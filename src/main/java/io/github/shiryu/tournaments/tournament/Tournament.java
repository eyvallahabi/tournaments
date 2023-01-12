package io.github.shiryu.tournaments.tournament;

import io.github.shiryu.tournaments.player.TournamentInfo;
import io.github.shiryu.tournaments.tournament.settings.TournamentSettings;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Tournament {

    private final String id;

    private final TournamentSettings settings;

    private final List<TournamentInfo> participation = new ArrayList<>();

    private boolean active;

    public Tournament(@NotNull final String id){
        this.id = id;

        this.settings = new TournamentSettings(this);
    }

    public void join(@NotNull final Player player){
        if (!active)
            return;

        if (!this.settings.check(player))
            return;

        if (this.isJoined(player))
            return;

        this.participation.add(
                new TournamentInfo(
                        player.getUniqueId(),
                        this
                )
        );
    }

    public boolean isJoined(@NotNull final Player player){
        return this.participation.stream()
                .anyMatch(info -> info.getPlayer().equals(player.getUniqueId()));
    }

}
