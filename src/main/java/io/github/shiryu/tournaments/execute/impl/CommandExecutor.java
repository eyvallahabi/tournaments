package io.github.shiryu.tournaments.execute.impl;

import io.github.shiryu.tournaments.environment.TournamentEnvironment;
import io.github.shiryu.tournaments.environment.type.SenderType;
import io.github.shiryu.tournaments.execute.Executable;
import io.github.shiryu.tournaments.execute.annotation.Executation;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Executation(id = "command")
public class CommandExecutor implements Executable {

    @Override
    public void execute(@NotNull final TournamentEnvironment environment) {
        final Player player = environment.getPlayer();
        final SenderType type = environment.getType();

        if (type == null)
            return;

        switch (type){
            case PLAYER ->
                Bukkit.dispatchCommand(
                        player,
                        environment.getArgsShaped()
                                .replaceAll("%player%", player.getName())
                );
            case CONSOLE ->
                Bukkit.dispatchCommand(
                        Bukkit.getConsoleSender(),
                        environment.getArgsShaped()
                                .replaceAll("%player%", player.getName())
                );

        }
    }


}
