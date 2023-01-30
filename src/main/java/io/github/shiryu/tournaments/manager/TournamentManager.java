package io.github.shiryu.tournaments.manager;

import io.github.shiryu.tournaments.tournament.Tournament;
import lombok.Getter;
import lombok.experimental.UtilityClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@UtilityClass
public class TournamentManager {

    @Getter
    private final List<Tournament> activeTournaments = new ArrayList<>();

    @Nullable
    public Tournament find(@NotNull final UUID uuid){
        return getActiveTournaments()
                .stream()
                .filter(tournament -> tournament.find(uuid).isEmpty())
                .findFirst()
                .orElse(null);
    }

    @Nullable
    public Tournament find(@NotNull final Player player){
        return find(
                player.getUniqueId()
        );
    }
}
