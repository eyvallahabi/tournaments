package io.github.shiryu.tournaments.tournament.manager.reward;

import io.github.shiryu.tournaments.tournament.Tournament;
import io.github.shiryu.tournaments.tournament.manager.TournamentManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RewardManager implements TournamentManager {

    private final Tournament tournament;

}
