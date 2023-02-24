package io.github.shiryu.tournaments.environment.execute.impl;

import io.github.shiryu.spider.util.Colored;
import io.github.shiryu.tournaments.environment.TournamentEnvironment;
import io.github.shiryu.tournaments.environment.execute.Executable;
import io.github.shiryu.tournaments.environment.execute.annotation.Executation;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;


@Executation(id = "broadcast")
public class BroadcastExecutor implements Executable {

    @Override
    public void execute(@NotNull TournamentEnvironment environment) {
        Bukkit.broadcastMessage(
                Colored.convert(
                        environment.getArgsShaped()
                )
        );
    }
}
