package io.github.shiryu.tournaments.tournament.type.impl.defaults;

import com.cryptomorin.xseries.XMaterial;
import io.github.shiryu.tournaments.listener.Listener;
import io.github.shiryu.tournaments.listener.bukkit.BukkitListeners;
import io.github.shiryu.tournaments.manager.TournamentManager;
import io.github.shiryu.tournaments.tournament.Tournament;
import io.github.shiryu.tournaments.tournament.type.TournamentType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class CraftTournamentType implements TournamentType {

    private final List<XMaterial> whitelist;

    private final List<Listener> listeners = new ArrayList<>();

    public void enable(){
        this.register(
                BukkitListeners.newListener(CraftItemEvent.class, event ->{
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

                    final Tournament tournament = TournamentManager.find(player);

                    if (tournament == null)
                        return;

                    this.update(tournament, player);
                })
        );
    }
}
