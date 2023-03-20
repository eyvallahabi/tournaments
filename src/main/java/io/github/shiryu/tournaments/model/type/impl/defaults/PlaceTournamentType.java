package io.github.shiryu.tournaments.model.type.impl.defaults;

import com.cryptomorin.xseries.XMaterial;
import io.github.shiryu.tournaments.api.TournamentsAPI;
import io.github.shiryu.tournaments.model.Tournament;
import io.github.shiryu.tournaments.model.type.TournamentType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class PlaceTournamentType extends TournamentType {

    private final List<XMaterial> whitelist;

    @EventHandler
    public void block(final BlockPlaceEvent event){
        final Player player = event.getPlayer();

        if (!this.whitelist.contains(event.getBlock().getType()))
            return;

        final Tournament tournament = TournamentsAPI.tournamentByPlayer(player);

        if (tournament == null)
            return;

        this.update(tournament, player);
    }
}
