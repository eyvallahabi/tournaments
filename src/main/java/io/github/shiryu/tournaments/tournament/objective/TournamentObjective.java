package io.github.shiryu.tournaments.tournament.objective;

import io.github.shiryu.tournaments.tournament.objective.listener.ObjectiveListener;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface TournamentObjective{

    @NotNull
    List<ObjectiveListener> getListeners();


    default void register(@NotNull final ObjectiveListener... listeners){
        if (listeners == null)
            return;

        for (ObjectiveListener listener : listeners)
            getListeners().add(listener);
    }

    default <T extends Event> void accept(@NotNull final T event){
        this.getListeners().stream()
                .filter(listener -> listener.getEventClass().equals(event))
                .forEach(listener -> listener.listen(event));
    }
}
