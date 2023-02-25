package io.github.shiryu.tournaments.tournament.requirement;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface Requirement {

    boolean control(@NotNull final Player player, @NotNull final List<String> args);
}
