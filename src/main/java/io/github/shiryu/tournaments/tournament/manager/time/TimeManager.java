package io.github.shiryu.tournaments.tournament.manager.time;

import io.github.shiryu.tournaments.tournament.Tournament;
import io.github.shiryu.tournaments.tournament.manager.TournamentManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TimeManager implements TournamentManager {

    private final Tournament tournament;

}
