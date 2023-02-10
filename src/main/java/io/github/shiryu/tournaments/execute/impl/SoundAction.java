package io.github.shiryu.tournaments.execute.impl;

import com.cryptomorin.xseries.XSound;
import io.github.shiryu.tournaments.environment.TournamentEnvironment;
import io.github.shiryu.tournaments.execute.Executable;
import io.github.shiryu.tournaments.execute.annotation.Executation;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Executation(id = "sound")
public class SoundAction implements Executable {

    @Override
    public void execute(@NotNull TournamentEnvironment environment) {
        final Player player = environment.getPlayer();

        final XSound sound = XSound.matchXSound(environment.getArgs().get(0))
                .orElse(null);

        if (sound == null)
            return;

        sound.play(
                player
        );
    }
}
