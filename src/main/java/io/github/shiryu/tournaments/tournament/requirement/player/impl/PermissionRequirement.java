package io.github.shiryu.tournaments.tournament.requirement.player.impl;

import io.github.shiryu.tournaments.tournament.requirement.player.PlayerRequirement;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Getter
@RequiredArgsConstructor
public class PermissionRequirement implements PlayerRequirement {

    private final String permission;

    @Override
    public boolean control(@NotNull final Player player) {
        return player.hasPermission(this.permission);
    }
}
