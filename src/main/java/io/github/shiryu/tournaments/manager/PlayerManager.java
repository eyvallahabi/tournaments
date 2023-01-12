package io.github.shiryu.tournaments.manager;

import com.google.common.collect.Maps;
import io.github.shiryu.tournaments.player.TournamentInfo;
import io.github.shiryu.tournaments.player.TournamentPlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class PlayerManager {

    private final Map<UUID, TournamentPlayer> players = Maps.newConcurrentMap();

    @Nullable
    public TournamentPlayer get(@NotNull final UUID uuid){
        return this.players.get(uuid);
    }

    @Nullable
    public TournamentPlayer get(@NotNull final Player player){
        return this.get(player.getUniqueId());
    }

    @NotNull
    public TournamentPlayer getOrSet(@NotNull final Player player){
        if (!players.containsKey(player.getUniqueId()))
            this.players.put(
                    player.getUniqueId(),
                    new TournamentPlayer(player.getUniqueId())
            );

        return this.get(player);
    }

}
