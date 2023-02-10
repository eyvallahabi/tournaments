package io.github.shiryu.tournaments.execute.impl;

import io.github.shiryu.tournaments.environment.TournamentEnvironment;
import io.github.shiryu.tournaments.execute.Executable;
import io.github.shiryu.tournaments.execute.annotation.Executation;
import io.github.shiryu.tournaments.util.Colored;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Executation(id = "message")
public class MessageExecutor implements Executable {

    @Override
    public void execute(@NotNull TournamentEnvironment environment) {
        if (environment.getArgs().isEmpty())
            return;

        final Player player = environment.getPlayer();

        final String message = environment.getArgs().get(0);

        player.sendMessage(
                Colored.convert(
                        message
                                .replaceAll("%player%", player.getName())
                )
        );
    }

}
