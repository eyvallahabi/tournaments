package io.github.shiryu.tournaments.tournament.requirement;

import org.jetbrains.annotations.NotNull;

public interface TournamentRequirement<T> {

    boolean control(@NotNull final T object);
}
