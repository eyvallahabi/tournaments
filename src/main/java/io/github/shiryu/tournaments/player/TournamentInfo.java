package io.github.shiryu.tournaments.player;

import io.github.shiryu.tournaments.tournament.Tournament;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class TournamentInfo {

    private final UUID player;
    private final Tournament tournament;

    private boolean haveToLoad;

    private int objective;
}
