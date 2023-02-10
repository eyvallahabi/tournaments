package io.github.shiryu.tournaments.execute;

import io.github.shiryu.tournaments.environment.TournamentEnvironment;
import org.jetbrains.annotations.NotNull;


public interface Executable {

    void execute(@NotNull final TournamentEnvironment environment);
}
