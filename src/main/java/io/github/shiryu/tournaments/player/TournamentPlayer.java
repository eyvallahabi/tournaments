package io.github.shiryu.tournaments.player;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class TournamentPlayer {

    private final UUID uuid;

    private TournamentInfo info;
}
