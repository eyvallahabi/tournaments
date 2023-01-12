package io.github.shiryu.tournaments.manager;

import io.github.shiryu.tournaments.tournament.Tournament;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TournamentManager {

    private final List<Tournament> tournaments = new ArrayList<>();

}
