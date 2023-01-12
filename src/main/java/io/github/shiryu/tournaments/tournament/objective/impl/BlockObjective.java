package io.github.shiryu.tournaments.tournament.objective.impl;

import com.cryptomorin.xseries.XBlock;
import com.cryptomorin.xseries.XMaterial;
import io.github.shiryu.tournaments.tournament.objective.listener.ObjectiveListener;
import io.github.shiryu.tournaments.tournament.objective.TournamentObjective;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BlockObjective implements TournamentObjective {

    private final List<ObjectiveListener> listeners = new ArrayList<>();

    private final XMaterial material;
    private final boolean excludePlaced;

    public BlockObjective(@NotNull final XMaterial material, @NotNull final boolean excludePlaced){
        this.material = material;
        this.excludePlaced = excludePlaced;

        this.registerBlockBreak();
        this.registerBlockPlace();
    }

    private void registerBlockBreak(){
        this.register(
                new ObjectiveListener<BlockBreakEvent>() {
                    @Override
                    public void listen(@NotNull BlockBreakEvent event) {
                        final Player player = event.getPlayer();
                        final XMaterial block = XMaterial.matchXMaterial(event.getBlock().getType());

                        if (!block.equals(material))
                            return;


                    }

                    @Override
                    public @NotNull Class<?> getEventClass() {
                        return BlockBreakEvent.class;
                    }
                }
        );
    }

    private void registerBlockPlace(){
        this.register(
                new ObjectiveListener<BlockPlaceEvent>() {
                    @Override
                    public void listen(@NotNull final BlockPlaceEvent event) {
                        if (!excludePlaced)
                            return;

                    }

                    @Override
                    public @NotNull Class<?> getEventClass() {
                        return BlockPlaceEvent.class;
                    }
                }
        );
    }
}
