package io.github.shiryu.tournaments.tournament.manager;

import io.github.shiryu.tournaments.tournament.Tournament;
import org.jetbrains.annotations.NotNull;

public interface TournamentManager {

    @NotNull
    Tournament getTournament();

    default <T extends TournamentManager> T getManager(){
        return (T) this;
    }
}
