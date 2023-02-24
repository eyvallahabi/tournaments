package io.github.shiryu.tournaments.database;

import io.github.shiryu.spider.storage.sql.SQLConnection;
import io.github.shiryu.spider.storage.sql.SQLStorage;
import io.github.shiryu.spider.storage.sql.credentials.MySQLCredentials;
import io.github.shiryu.spider.storage.sql.credentials.SQLiteCredentials;
import io.github.shiryu.spider.storage.sql.type.MySQLConnection;
import io.github.shiryu.spider.storage.sql.type.SQLiteConnection;
import io.github.shiryu.spider.util.functional.StaticEntry;
import io.github.shiryu.tournaments.TournamentPlugin;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.AbstractMap;
import java.util.UUID;

@Getter
public class TournamentDatabase {

    private final TournamentPlugin plugin;

    private SQLStorage storage;

    public TournamentDatabase(@NotNull final TournamentPlugin plugin){
        this.plugin = plugin;

        this.storage = new SQLStorage(this.create(plugin.getFiles().getSettings().DATABASE_TYPE));
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
                                "TOURNAMENT",
                                "TEXT"
                        )
                );
    }

    private SQLConnection create(@NotNull final DatabaseType type){
        SQLConnection connection = null;

        switch (type){
            case MYSQL ->{
                connection = new MySQLConnection(
                        new MySQLCredentials(
                                plugin.getFiles().getSettings().CREDENTIAL_HOST,
                                plugin.getFiles().getSettings().CREDENTIAL_USERNAME,
                                plugin.getFiles().getSettings().CREDENTIAL_PASSWORD,
                                plugin.getFiles().getSettings().CREDENTIAL_DATABASE,
                                plugin.getFiles().getSettings().CREDENTIAL_PORT
                        )
                );
            }
            case SQLITE -> {
                connection = new SQLiteConnection(
                        new SQLiteCredentials(
                                "tournaments",
                                plugin.getDataFolder().getAbsolutePath() + "/tournaments.db"
                        )
                );
            }
        }

        return connection;
    }
}
