package io.github.shiryu.tournaments.player;

import io.github.shiryu.tournaments.model.Tournament;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class TournamentPlayer {

    private final UUID uuid;

    private List<TournamentInfo> infos = new ArrayList<>();

    public void update(@NotNull final Tournament tournament){
        this.infos.stream()
                .filter(info -> info.getUuid().equals(tournament.getUuid()))
                .findFirst()
                .ifPresent(info -> info.increase());
    }
}
