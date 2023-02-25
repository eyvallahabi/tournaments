package io.github.shiryu.tournaments.tournament.reward;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface Reward {

    void give(@NotNull final Player player, @NotNull final List<String> args);
}
