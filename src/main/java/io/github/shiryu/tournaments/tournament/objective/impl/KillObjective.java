package io.github.shiryu.tournaments.tournament.objective.impl;

import io.github.shiryu.tournaments.tournament.Tournament;
import io.github.shiryu.tournaments.tournament.objective.TournamentObjective;
import io.github.shiryu.tournaments.tournament.objective.listener.ObjectiveListener;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class KillObjective implements TournamentObjective {

    private final Tournament tournament;

    private final List<ObjectiveListener> listeners = new ArrayList<>();

    @Override
    public void activate() {
        this.register(
                new ObjectiveListener<PlayerDeathEvent>() {

                    @Override
                    public void listen(@NotNull PlayerDeathEvent event) {
                        final Player player = event.getEntity();

                        if (player.getKiller() == null)
                            return;

                        tournament.getInfo(player.getKiller())
                                .ifPresent(info -> info.addObjective(1));
                    }

                    @Override
                    public @NotNull Class<?> getEventClass() {
                        return PlayerDeathEvent.class;
                    }
                }

        );
    }
}
