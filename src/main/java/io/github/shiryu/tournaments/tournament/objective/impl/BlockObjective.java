package io.github.shiryu.tournaments.tournament.objective.impl;

import com.cryptomorin.xseries.XMaterial;
import io.github.shiryu.tournaments.tournament.Tournament;
import io.github.shiryu.tournaments.tournament.objective.listener.ObjectiveListener;
import io.github.shiryu.tournaments.tournament.objective.TournamentObjective;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BlockObjective implements TournamentObjective {

    private final Tournament tournament;

    private final List<XMaterial> materials = new ArrayList<>();
    private final boolean excludePlaced;

    private final List<ObjectiveListener> listeners = new ArrayList<>();

    public BlockObjective(@NotNull final Tournament tournament, @NotNull final boolean excludePlaced){
        this.tournament = tournament;
        this.excludePlaced = excludePlaced;
    }

    @Override
    public void activate(){
        this.register(
                new ObjectiveListener<BlockBreakEvent>() {
                    @Override
                    public void listen(@NotNull BlockBreakEvent event) {
                        final Player player = event.getPlayer();
                        final XMaterial block = XMaterial.matchXMaterial(event.getBlock().getType());

                        if (!materials.contains(block))
                            return;

                        tournament.getInfo(player)
                                        .ifPresent(info -> info.addObjective(1));
                    }

                    @Override
                    public @NotNull Class<?> getEventClass() {
                        return BlockBreakEvent.class;
                    }
                }
        );

        this.register(
                new ObjectiveListener<BlockPlaceEvent>() {
                    @Override
                    public void listen(@NotNull final BlockPlaceEvent event) {
                        final Player player = event.getPlayer();

                        if (!excludePlaced)
                            return;

                        final XMaterial block = XMaterial.matchXMaterial(event.getBlock().getType());

                        if (!materials.contains(block))
                            return;

                        tournament.getInfo(player)
                                .ifPresent(info -> info.addObjective(1));
                    }

                    @Override
                    public @NotNull Class<?> getEventClass() {
                        return BlockPlaceEvent.class;
                    }
                }
        );

    }
}
