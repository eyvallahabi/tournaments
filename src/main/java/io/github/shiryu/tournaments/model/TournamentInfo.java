package io.github.shiryu.tournaments.model;

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
