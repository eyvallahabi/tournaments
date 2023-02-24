package io.github.shiryu.tournaments;

import io.github.shiryu.tournaments.database.TournamentDatabase;
import io.github.shiryu.tournaments.files.TournamentFiles;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class TournamentPlugin extends JavaPlugin {

    @Getter
    private static TournamentPlugin instance;

    private TournamentFiles files;
    private TournamentDatabase database;

    @Override
    public void onEnable() {

        this.files = new TournamentFiles(this);

        this.database = new TournamentDatabase(this);
        this.database.connect();

    }
}
