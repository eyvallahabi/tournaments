package io.github.shiryu.tournaments.tournament.objective.listener.impl;

import io.github.shiryu.tournaments.tournament.objective.listener.ObjectiveListener;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;
import org.jetbrains.annotations.NotNull;

public class BlockBreakListener implements ObjectiveListener<BlockBreakEvent> {

    @Override
    public void listen(@NotNull final BlockBreakEvent event) {

    }

    @Override
    public @NotNull Class<?> getEventClass() {
        return BlockBreakEvent.class;
    }
}
