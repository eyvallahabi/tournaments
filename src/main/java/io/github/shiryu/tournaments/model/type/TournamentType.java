package io.github.shiryu.tournaments.model.type;

import io.github.shiryu.tournaments.api.TournamentsAPI;
import io.github.shiryu.tournaments.model.Tournament;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

public class TournamentType implements Listener {

    public void update(@NotNull final Tournament tournament, @NotNull final Player player){
        tournament.find(player)
                .ifPresent(info -> info.increase());
    }

    public void findAndUpdate(@NotNull final Player player){
        if (player == null)
            return;

        final Tournament tournament = TournamentsAPI.tournamentByPlayer(player);

        if (tournament == null)
            return;

        this.update(tournament, player);
    }

}
