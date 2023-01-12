package io.github.shiryu.tournaments.tournament;

import io.github.shiryu.tournaments.tournament.objective.TournamentObjective;
import io.github.shiryu.tournaments.tournament.settings.TournamentSettings;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class Tournament {

    private final String id;

    private final TournamentSettings settings;

    private final List<TournamentObjective> objectives = new ArrayList<>();
    private final List<TournamentInfo> participation = new ArrayList<>();

    private boolean active;

    public Tournament(@NotNull final String id){
        this.id = id;

        this.settings = new TournamentSettings(this);
    }

    public void accept(@NotNull final Event event){
        this.objectives.forEach(objective -> objective.accept(event));
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

    public void leave(@NotNull final Player player){
        if (!active)
            return;

        if (!this.isJoined(player))
            return;

        this.getInfo(player)
                .ifPresent(info -> this.participation.remove(info));
    }

    @NotNull
    public Optional<TournamentInfo> getInfo(@NotNull final Player player){
        return Optional.ofNullable(
                this.participation.stream()
                        .filter(info -> info.getPlayer().equals(player.getUniqueId()))
                        .findFirst()
                        .get()
        );
    }
    public boolean isJoined(@NotNull final Player player){
        return this.participation.stream()
                .anyMatch(info -> info.getPlayer().equals(player.getUniqueId()));
    }

}
