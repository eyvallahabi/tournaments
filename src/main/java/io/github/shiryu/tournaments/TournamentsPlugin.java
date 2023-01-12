package io.github.shiryu.tournaments;

import io.github.shiryu.tournaments.manager.PlayerManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class TournamentsPlugin extends JavaPlugin {

    @Getter
    private static TournamentsPlugin instance;

    private PlayerManager playerManager;

    @Override
    public void onEnable() {
        instance = this;

        this.registerManagers();
    }

    @Override
    public void onDisable() {

    }

    private void registerManagers(){
        this.playerManager = new PlayerManager();
    }
}
