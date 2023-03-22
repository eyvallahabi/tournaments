package io.github.shiryu.tournaments.storage.impl.sql;

import com.google.gson.Gson;
import io.github.shiryu.spider.storage.sql.SQLConnection;
import io.github.shiryu.spider.storage.sql.SQLExecutor;
import io.github.shiryu.spider.storage.sql.SQLStorage;
import io.github.shiryu.spider.storage.sql.credentials.MySQLCredentials;
import io.github.shiryu.spider.storage.sql.credentials.SQLiteCredentials;
import io.github.shiryu.spider.storage.sql.type.MySQLConnection;
import io.github.shiryu.spider.storage.sql.type.SQLiteConnection;
import io.github.shiryu.spider.util.functional.StaticEntry;
import io.github.shiryu.tournaments.TournamentsPlugin;
import io.github.shiryu.tournaments.configuration.Configs;
import io.github.shiryu.tournaments.player.TournamentPlayer;
import io.github.shiryu.tournaments.storage.TournamentDatabase;
import io.github.shiryu.tournaments.storage.type.StorageType;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Getter
public class SQLDatabase extends TournamentDatabase {

    private final SQLStorage storage;

    public SQLDatabase(@NotNull final StorageType type){
        this.storage = new SQLStorage(this.create(type));
    }

    public SQLConnection create(@NotNull final StorageType type){
        SQLConnection connection = null;

        switch (type){
            case MYSQL ->
                connection = new MySQLConnection(
                        new MySQLCredentials(
                                Configs.getConfig().getOrSet("database.host", "localhost"),
                                Configs.getConfig().getOrSet("database.username", "user"),
                                Configs.getConfig().getOrSet("database.password", "12345"),
                                Configs.getConfig().getOrSet("database.database", "tournaments"),
                                Configs.getConfig().getOrSet("database.port", 3336)
                        )
                );
            case SQLITE ->
                connection = new SQLiteConnection(
                        new SQLiteCredentials(
                                "tournaments",
                                TournamentsPlugin.getPlugin().getDataFolder().getAbsolutePath() + "/tournaments.db"
                        )
                );
        }

        return connection;
    }

    public void connect(){
        this.storage.connect();

        this.storage.getExecutor()
                .createTable(
                        "tournaments",
                        new StaticEntry<>(
                                "UUID",
                                "VARCHAR(255)"
                        ),
                        new StaticEntry<>(
                                "INFOS",
                                "TEXT"
                        )
                );
    }

    @Override
    public @NotNull Optional<TournamentPlayer> load(@NotNull UUID uuid) {
        final SQLExecutor executor = this.storage.getExecutor();

        if (executor.exists("tournaments", "UUID", uuid)){
            final Gson gson = new Gson();

            final TournamentPlayer player = new TournamentPlayer(uuid);

            try{
                player.setInfos(
                        gson.fromJson(
                                (String) executor.get("tournaments", "INFOS", "UUID", "=", uuid),
                                List.class
                        )
                );
            }catch (final Exception exception){
                return Optional.empty();
            }

            return Optional.of(player);
        }

        return Optional.empty();
    }
}
