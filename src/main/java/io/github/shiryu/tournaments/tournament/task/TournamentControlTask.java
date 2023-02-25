package io.github.shiryu.tournaments.tournament.task;

import io.github.shiryu.tournaments.TournamentPlugin;
import io.github.shiryu.tournaments.tournament.Tournament;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

@Getter
@RequiredArgsConstructor
public class TournamentControlTask extends BukkitRunnable {

    private final Tournament tournament;

    @Override
    public void run() {
        if (tournament.getSettings().getFinish() <= System.currentTimeMillis()){
            tournament.stop();
        }
    }

    public void start(){
        this.runTaskTimer(
                TournamentPlugin.getInstance(),
                100L,
                20L
        );
    }
}
