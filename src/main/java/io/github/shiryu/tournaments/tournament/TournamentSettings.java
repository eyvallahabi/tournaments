package io.github.shiryu.tournaments.tournament;

import io.github.shiryu.tournaments.environment.control.Controller;
import io.github.shiryu.tournaments.environment.execute.Executable;
import io.github.shiryu.tournaments.tournament.Tournament;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@RequiredArgsConstructor
public class TournamentSettings {

    //TODO REWARD & REQUİREMENTS

    private final Tournament tournament;

    private boolean autoJoin;

    private final List<String> disabledWorlds = new ArrayList<>();

    private boolean active;

    private long start;
    private long finish;
}
