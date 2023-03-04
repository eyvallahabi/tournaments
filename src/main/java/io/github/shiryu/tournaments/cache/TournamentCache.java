package io.github.shiryu.tournaments.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.google.gson.Gson;
import io.github.shiryu.spider.storage.sql.SQLExecutor;
import io.github.shiryu.tournaments.TournamentPlugin;
import io.github.shiryu.tournaments.tournament.Tournament;
import lombok.experimental.UtilityClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.Duration;
import java.util.*;

@UtilityClass
public class TournamentCache {

    private final Cache<UUID, Optional<Tournament>> TOURNAMENTS = Caffeine.newBuilder()
            .maximumSize(100)
            .expireAfterWrite(Duration.ofMinutes(5))
            .build(TournamentCache::load);

    @Nullable
    public Tournament tournamentById(@NotNull final UUID uuid){
        return TOURNAMENTS
                .getIfPresent(uuid)
                .orElse(null);
    }

    @Nullable
    public Tournament tournamentByPlayer(@NotNull final Player player){
        return TOURNAMENTS
                .asMap()
                .values()
                .stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .filter(tournament -> !tournament.find(player).isEmpty())
                .findFirst()
                .orElse(null);
    }


    @NotNull
    private Optional<Tournament> load(@NotNull final UUID uuid){
        final SQLExecutor executor = TournamentPlugin.getInstance().getDatabase().getStorage().getExecutor();

        if (executor.exists("tournaments", "UUID", uuid)){
            final Gson gson = new Gson();

            Tournament tournament;

            try{
                tournament = gson.fromJson(
                        (String) executor.get("tournament", "TOURNAMENT", "UUID", "=", uuid),
                        Tournament.class
                );
            }catch (final Exception exception) {
                return Optional.empty();
            }

            if (tournament == null)
                Optional.empty();

            return Optional.of(tournament);
        }

        return Optional.empty();
    }

}
