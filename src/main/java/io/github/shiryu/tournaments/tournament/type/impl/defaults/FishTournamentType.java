package io.github.shiryu.tournaments.tournament.type.impl.defaults;

import io.github.shiryu.tournaments.cache.TournamentCache;
import io.github.shiryu.tournaments.listener.bukkit.BukkitListeners;
import io.github.shiryu.tournaments.tournament.Tournament;
import io.github.shiryu.tournaments.tournament.type.TournamentType;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerFishEvent;

public class FishTournamentType extends TournamentType {

    public FishTournamentType(){
        this.register(
                BukkitListeners.newListener(PlayerFishEvent.class, event ->{
                    if (event.getState() != PlayerFishEvent.State.CAUGHT_FISH)
                        return;

                    final Player player = event.getPlayer();

                    final Tournament tournament = TournamentCache.tournamentByPlayer(player);

                    if (tournament == null)
                        return;

                    this.update(tournament, player);
                })
        );
    }
}
