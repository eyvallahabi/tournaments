package io.github.shiryu.tournaments.player;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class TournamentPlayer {

    private final UUID uuid;
}
