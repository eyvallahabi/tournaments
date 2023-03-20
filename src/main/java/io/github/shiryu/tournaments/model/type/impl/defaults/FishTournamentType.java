package io.github.shiryu.tournaments.model.type.impl.defaults;

import io.github.shiryu.tournaments.api.TournamentsAPI;
import io.github.shiryu.tournaments.model.Tournament;
import io.github.shiryu.tournaments.model.type.TournamentType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerFishEvent;

public class FishTournamentType extends TournamentType {

    @EventHandler
    public void fish(final PlayerFishEvent event){
        if (event.getState() != PlayerFishEvent.State.CAUGHT_FISH)
            return;

        final Player player = event.getPlayer();

        final Tournament tournament = TournamentsAPI.tournamentByPlayer(player);

        if (tournament == null)
            return;

        this.update(tournament, player);
    }

}
