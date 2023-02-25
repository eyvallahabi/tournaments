package io.github.shiryu.tournaments.tournament.type.impl.envoys;

import com.badbones69.crazyenvoys.api.events.EnvoyOpenEvent;
import io.github.shiryu.tournaments.listener.bukkit.BukkitListeners;
import io.github.shiryu.tournaments.tournament.type.TournamentType;

public class CrazyEnvoysType extends TournamentType{

    public CrazyEnvoysType(){
        this.register(
                BukkitListeners.newListener(
                    EnvoyOpenEvent.class,
                    (event -> this.findAndUpdate(event.getPlayer()))
                )
        );
    }
}
