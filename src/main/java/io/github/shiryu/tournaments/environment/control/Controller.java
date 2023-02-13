package io.github.shiryu.tournaments.environment.control;

import io.github.shiryu.tournaments.environment.TournamentEnvironment;
import org.jetbrains.annotations.NotNull;

public interface Controller {

    boolean control(@NotNull final TournamentEnvironment environment);
}
