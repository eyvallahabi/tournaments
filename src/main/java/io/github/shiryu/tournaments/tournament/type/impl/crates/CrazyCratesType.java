package io.github.shiryu.tournaments.tournament.type.impl.crates;

import com.badbones69.crazycrates.api.events.PlayerPrizeEvent;
import io.github.shiryu.tournaments.listener.bukkit.BukkitListeners;
import io.github.shiryu.tournaments.tournament.type.TournamentType;
import lombok.Getter;

@Getter
public class CrazyCratesType extends TournamentType {

    public CrazyCratesType(){
        this.register(
                BukkitListeners.newListener(
                        PlayerPrizeEvent.class,
                        (event -> this.findAndUpdate(event.getPlayer()))
                )
        );
    }
}
