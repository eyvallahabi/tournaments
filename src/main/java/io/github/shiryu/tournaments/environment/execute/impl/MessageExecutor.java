package io.github.shiryu.tournaments.environment.execute.impl;

import io.github.shiryu.spider.util.Colored;
import io.github.shiryu.tournaments.environment.TournamentEnvironment;
import io.github.shiryu.tournaments.environment.execute.Executable;
import io.github.shiryu.tournaments.environment.execute.annotation.Executation;
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
