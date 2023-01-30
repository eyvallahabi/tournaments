package io.github.shiryu.tournaments.tournament.type;

import io.github.shiryu.tournaments.listener.Listenable;
import io.github.shiryu.tournaments.tournament.Tournament;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public interface TournamentType extends Listenable {

    default void update(@NotNull final Tournament tournament, @NotNull final Player player){
        tournament.find(player)
                .ifPresent(info -> info.increase());
    }
}
