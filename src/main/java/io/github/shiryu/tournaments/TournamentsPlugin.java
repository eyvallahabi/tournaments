package io.github.shiryu.tournaments;

import io.github.shiryu.tournaments.configuration.Configs;
import io.github.shiryu.tournaments.model.Tournament;
import io.github.shiryu.tournaments.storage.TournamentDatabase;
import io.github.shiryu.tournaments.storage.impl.mongo.MongoDatabase;
import io.github.shiryu.tournaments.storage.impl.sql.SQLDatabase;
import io.github.shiryu.tournaments.storage.type.StorageType;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.UUID;

@Getter
public class TournamentsPlugin extends JavaPlugin {

    @Getter
    private static TournamentsPlugin plugin;

    private TournamentDatabase database;

    @Override
    public void onEnable() {
        Configs.load(this);

        this.loadDatabase();
    }

    private void loadDatabase(){
        final StorageType type = StorageType.valueOf(Configs.getConfig().getOrSet("database.type", "SQLITE"));

        switch (type){
            case MONGO -> this.database = new MongoDatabase();
            case MYSQL,SQLITE -> this.database = new SQLDatabase(type);
        }
    }

}
