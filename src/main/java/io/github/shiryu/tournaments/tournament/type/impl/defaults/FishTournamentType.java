package io.github.shiryu.tournaments.tournament.type.impl.defaults;

import io.github.shiryu.tournaments.cache.TournamentCache;
import io.github.shiryu.tournaments.listener.Listener;
import io.github.shiryu.tournaments.listener.bukkit.BukkitListeners;
import io.github.shiryu.tournaments.tournament.Tournament;
import io.github.shiryu.tournaments.tournament.type.TournamentType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerFishEvent;

import java.util.ArrayList;
import java.util.List;

@Getter
public class FishTournamentType implements TournamentType {

    private final List<Listener> listeners = new ArrayList<>();

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
