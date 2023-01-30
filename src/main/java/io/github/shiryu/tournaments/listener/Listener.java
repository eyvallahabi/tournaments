package io.github.shiryu.tournaments.listener;

import org.jetbrains.annotations.NotNull;

public interface Listener<E> {

    void listen(@NotNull final E event);

    @NotNull
    Class<E> getEventClass();
}
