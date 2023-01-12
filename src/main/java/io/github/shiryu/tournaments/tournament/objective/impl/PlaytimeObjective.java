package io.github.shiryu.tournaments.tournament.objective.impl;

import io.github.shiryu.tournaments.TournamentsPlugin;
import io.github.shiryu.tournaments.tournament.Tournament;
import io.github.shiryu.tournaments.tournament.objective.TournamentObjective;
import io.github.shiryu.tournaments.tournament.objective.listener.ObjectiveListener;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class PlaytimeObjective implements TournamentObjective {

    private final Tournament tournament;

    private final int updateTime;

    private final List<ObjectiveListener> listeners = new ArrayList<>();

    private BukkitTask task;

    @Override
    public void activate() {
        this.task = Bukkit.getScheduler()
                .runTaskTimerAsynchronously(
                        TournamentsPlugin.getInstance(),
                        this::update,
                        20L,
                        this.updateTime
                );
    }

    private void update(){
        this.tournament.getParticipation()
                .forEach(info -> info.addObjective(10));
    }
}
