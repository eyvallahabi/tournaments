package io.github.shiryu.tournaments.tournament.type;

import io.github.shiryu.tournaments.cache.TournamentCache;
import io.github.shiryu.tournaments.listener.Listenable;
import io.github.shiryu.tournaments.listener.Listener;
import io.github.shiryu.tournaments.tournament.Tournament;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TournamentType implements Listenable {

    private final List<Listener> listeners = new ArrayList<>();

    public void update(@NotNull final Tournament tournament, @NotNull final Player player){
        tournament.find(player)
                .ifPresent(info -> info.increase());
    }

    public void findAndUpdate(@NotNull final Player player){
        if (player == null)
            return;

        final Tournament tournament = TournamentCache.tournamentByPlayer(player);

        if (tournament == null)
            return;

        this.update(tournament, player);
    }
}
