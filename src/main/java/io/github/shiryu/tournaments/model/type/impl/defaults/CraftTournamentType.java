package io.github.shiryu.tournaments.model.type.impl.defaults;

import com.cryptomorin.xseries.XMaterial;
import io.github.shiryu.tournaments.api.TournamentsAPI;
import io.github.shiryu.tournaments.model.Tournament;
import io.github.shiryu.tournaments.model.type.TournamentType;
import lombok.RequiredArgsConstructor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

@RequiredArgsConstructor
public class CraftTournamentType extends TournamentType {

    private final List<XMaterial> whitelist;

    @EventHandler
    public void craft(final CraftItemEvent event){
        final Player player = (Player) event.getWhoClicked();
        final ItemStack item = event.getCurrentItem();

        int amount = item.getAmount();

        if (!this.whitelist.contains(item.getType()))
            return;

        if (event.isShiftClick()){
            final int max = event.getInventory().getMaxStackSize();

            final ItemStack[] items = event.getInventory().getMatrix();

            for (final ItemStack matrix : items){
                if (matrix == null || matrix.getType() == Material.AIR)
                    continue;

                final int size = matrix.getAmount();

                if (size < max && size > 0)
                    amount = size;
            }

            amount *= max;
        }

        final Tournament tournament = TournamentsAPI.tournamentByPlayer(player);

        if (tournament == null)
            return;

        this.update(tournament, player);
    }
}
