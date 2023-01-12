package io.github.shiryu.tournaments.listener;

import io.github.shiryu.tournaments.TournamentsPlugin;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

public class TournamentListener implements Listener {

    @EventHandler
    public void event(@NotNull final Event event){
        TournamentsPlugin.getInstance().getTournamentManager()
                .getTournaments().forEach(tournament -> tournament.accept(event));
    }
}
