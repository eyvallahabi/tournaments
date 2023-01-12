package io.github.shiryu.tournaments;

import io.github.shiryu.tournaments.listener.TournamentListener;
import io.github.shiryu.tournaments.manager.TournamentManager;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

@Getter
public class TournamentsPlugin extends JavaPlugin {

    @Getter
    private static TournamentsPlugin instance;

    private TournamentManager tournamentManager;

    @Override
    public void onEnable() {
        instance = this;

        this.registerListeners(
                new TournamentListener()
        );

        this.registerManagers();
    }

    @Override
    public void onDisable() {

    }

    private void registerListeners(final Listener... listeners){
        if (listeners == null)
            return;

        Arrays.stream(listeners)
                .forEach(listener -> Bukkit.getPluginManager().registerEvents(listener, this));
    }

    private void registerManagers(){
        this.tournamentManager = new TournamentManager();
    }
}
