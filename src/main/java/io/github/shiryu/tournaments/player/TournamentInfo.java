package io.github.shiryu.tournaments.player;

import io.github.shiryu.tournaments.tournament.Tournament;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class TournamentInfo {

    private final UUID player;
    private final Tournament tournament;

    private int objective;
}
