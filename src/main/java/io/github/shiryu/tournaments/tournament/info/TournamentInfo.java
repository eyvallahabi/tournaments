package io.github.shiryu.tournaments.tournament.info;

import io.github.shiryu.tournaments.tournament.Tournament;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class TournamentInfo {

    private final UUID uuid;

    private int objective;

    private Tournament tournament;

    public void increase(){
        setObjective(
                getObjective() + 1
        );
    }

    public void decrease(){
        setObjective(
                getObjective() - 1
        );
    }
}
