package io.github.shiryu.tournaments.tournament.objective.impl;

import com.cryptomorin.xseries.XEntity;
import io.github.shiryu.tournaments.tournament.Tournament;
import io.github.shiryu.tournaments.tournament.objective.TournamentObjective;
import io.github.shiryu.tournaments.tournament.objective.listener.ObjectiveListener;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDeathEvent;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class MobKillObjective implements TournamentObjective {

    private final Tournament tournament;

    private final List<EntityType> types = new ArrayList<>();
    private final List<ObjectiveListener> listeners;

    @Override
    public void activate() {
        this.register(
                new ObjectiveListener<EntityDeathEvent>() {
                    @Override
                    public void listen(@NotNull final EntityDeathEvent event) {
                        final LivingEntity entity = event.getEntity();

                        if (entity instanceof Player)
                            return;

                        if (entity.getKiller() == null)
                            return;

                        final Player player = entity.getKiller();

                        if (!types.contains(entity.getType()))
                            return;

                        tournament.getInfo(player)
                                .ifPresent(info -> info.addObjective(1));
                    }

                    @Override
                    public @NotNull Class<?> getEventClass() {
                        return EntityDeathEvent.class;
                    }
                }
        );
    }
}
