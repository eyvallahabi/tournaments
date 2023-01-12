package io.github.shiryu.tournaments.player;

import io.github.shiryu.tournaments.tournament.Tournament;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class TournamentPlayer {

    private final UUID uuid;

    private final List<TournamentInfo> info = new ArrayList<>();
}
