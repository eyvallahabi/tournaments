package io.github.shiryu.tournaments.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import io.github.shiryu.tournaments.tournament.Tournament;
import lombok.experimental.UtilityClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.Duration;
import java.util.UUID;

@UtilityClass
public class TournamentCache {

    private final Cache<UUID, Tournament> TOURNAMENTS = Caffeine.newBuilder()
            .maximumSize(100)
            .refreshAfterWrite(Duration.ofMinutes(5))
            .build(TournamentCache::load);

    @Nullable
    public Tournament tournamentById(@NotNull final UUID uuid){
        return TOURNAMENTS
                .getIfPresent(uuid);
    }

    @Nullable
    public Tournament tournamentByPlayer(@NotNull final Player player){
        return TOURNAMENTS
                .asMap()
                .values()
                .stream()
                .filter(tournament -> !tournament.find(player).isEmpty())
                .findFirst()
                .orElse(null);
    }


    @NotNull
    private Tournament load(@NotNull final UUID uuid){
        //TODO LOAD

        return null;
    }
}
