package io.github.shiryu.tournaments.api;

import io.github.shiryu.tournaments.TournamentsPlugin;
import io.github.shiryu.tournaments.model.Tournament;
import lombok.experimental.UtilityClass;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.UUID;

@UtilityClass
public class TournamentsAPI {

    @Nullable
    public Tournament tournamentById(@NotNull final UUID uuid){
        return TournamentsPlugin.getPlugin().getDatabase().getTournaments()
                .getIfPresent(uuid)
                .orElse(null);
    }

    @Nullable
    public Tournament tournamentByPlayer(@NotNull final Player player){
        return TournamentsPlugin.getPlugin().getDatabase().getTournaments()
                .asMap()
                .values()
                .stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .filter(tournament -> !tournament.find(player).isEmpty())
                .findFirst()
                .orElse(null);
    }

}
