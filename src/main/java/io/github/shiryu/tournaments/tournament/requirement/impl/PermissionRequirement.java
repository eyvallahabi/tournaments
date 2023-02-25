package io.github.shiryu.tournaments.tournament.requirement.impl;

import io.github.shiryu.tournaments.tournament.requirement.Requirement;
import io.github.shiryu.tournaments.tournament.requirement.annotation.RequirementInfo;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@RequirementInfo(id = "permission")
public class PermissionRequirement implements Requirement {

    @Override
    public boolean control(@NotNull final Player player, @NotNull final List<String> args) {
        return player.hasPermission(args.get(0));
    }

}

