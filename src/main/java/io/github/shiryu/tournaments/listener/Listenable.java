package io.github.shiryu.tournaments.listener;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public interface Listenable {

    @NotNull
    List<Listener> getListeners();

    default void register(@NotNull final Listener listener){
        if (getListeners().contains(listener))
            return;

        getListeners().add(
                listener
        );
    }

    default void register(@NotNull final Listener... listeners){
        if (listeners == null || listeners.length == 0)
            return;

        Arrays.stream(listeners)
                .forEach(listener -> this.register(listener));
    }

    default <T> void accept(@NotNull final T event){
        getListeners().stream()
                .filter(listener -> listener.getEventClass().equals(event.getClass()))
                .forEach(listener -> listener.listen(event));
    }
}
