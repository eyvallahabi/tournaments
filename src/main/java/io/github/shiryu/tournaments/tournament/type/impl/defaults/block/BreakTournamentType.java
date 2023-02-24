package io.github.shiryu.tournaments.tournament.type.impl.defaults.block;

import com.cryptomorin.xseries.XMaterial;
import io.github.shiryu.tournaments.cache.TournamentCache;
import io.github.shiryu.tournaments.listener.Listener;
import io.github.shiryu.tournaments.listener.bukkit.BukkitListeners;
import io.github.shiryu.tournaments.tournament.Tournament;
import io.github.shiryu.tournaments.tournament.type.TournamentType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BreakTournamentType implements TournamentType {

    private final List<XMaterial> whitelist;

    private final List<Listener> listeners = new ArrayList<>();

    public BreakTournamentType(@NotNull final List<XMaterial> whitelist){
        this.whitelist = whitelist;

        this.register(
                BukkitListeners.newListener(
                        BlockBreakEvent.class,
                        (event ->{
                            final Player player = event.getPlayer();

                            if (!this.whitelist.contains(event.getBlock().getType()))
                                return;

                            final Tournament tournament = TournamentCache.tournamentByPlayer(player);

                            if (tournament == null)
                                return;

                            this.update(tournament, player);
                        })
                )
        );
    }

}
