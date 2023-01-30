package io.github.shiryu.tournaments.tournament.type.impl.defaults.block;

import com.cryptomorin.xseries.XMaterial;
import io.github.shiryu.tournaments.listener.Listener;
import io.github.shiryu.tournaments.listener.bukkit.BukkitListeners;
import io.github.shiryu.tournaments.manager.TournamentManager;
import io.github.shiryu.tournaments.tournament.Tournament;
import io.github.shiryu.tournaments.tournament.type.TournamentType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class BreakBlockTournamentType implements TournamentType {

    private final List<XMaterial> whitelist;
    private final int objective;

    private final List<Listener> listeners = new ArrayList<>();

    public void enable(){
        this.register(
                BukkitListeners.newListener(
                        BlockBreakEvent.class,
                        (event ->{
                            final Player player = event.getPlayer();

                            if (!this.whitelist.contains(event.getBlock().getType()))
                                return;

                            final Tournament tournament = TournamentManager.find(player);

                            if (tournament == null)
                                return;

                            this.update(tournament, player);
                        })
                )
        );
    }

}
