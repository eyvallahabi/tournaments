package io.github.shiryu.tournaments.tournament.objective.listener;

import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

public interface ObjectiveListener<T extends Event>{

    void listen(@NotNull final T event);

    @NotNull
    Class<?> getEventClass();

}
