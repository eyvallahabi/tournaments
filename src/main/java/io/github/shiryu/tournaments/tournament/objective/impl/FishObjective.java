package io.github.shiryu.tournaments.tournament.objective.impl;

import io.github.shiryu.tournaments.tournament.Tournament;
import io.github.shiryu.tournaments.tournament.objective.TournamentObjective;
import io.github.shiryu.tournaments.tournament.objective.listener.ObjectiveListener;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerFishEvent;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class FishObjective implements TournamentObjective {

    private final Tournament tournament;

    private final List<ObjectiveListener> listeners = new ArrayList<>();

    @Override
    public void activate() {
        this.register(
                new ObjectiveListener<PlayerFishEvent>() {
                    @Override
                    public void listen(@NotNull PlayerFishEvent event) {
                        final Player player = event.getPlayer();

                        if (event.getState() != PlayerFishEvent.State.CAUGHT_FISH)
                            return;

                        tournament.getInfo(player)
                                .ifPresent(info -> info.addObjective(1));
                    }

                    @Override
                    public @NotNull Class<?> getEventClass() {
                        return PlayerFishEvent.class;
                    }
                }
        );
    }
}
