package io.github.shiryu.tournaments.environment.control.impl;

import io.github.shiryu.tournaments.environment.TournamentEnvironment;
import io.github.shiryu.tournaments.environment.control.Controller;
import io.github.shiryu.tournaments.environment.control.annotation.Controllable;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Controllable(id = "permission")
public class PermissionController implements Controller {

    @Override
    public boolean control(@NotNull TournamentEnvironment environment) {
        final Player player = environment.getPlayer();

        if (player == null)
            return false;

        return player.hasPermission(environment.getArgs().get(0));
    }
}
