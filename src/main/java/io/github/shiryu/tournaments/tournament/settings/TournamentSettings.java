package io.github.shiryu.tournaments.tournament.settings;

import io.github.shiryu.tournaments.tournament.Tournament;
import io.github.shiryu.tournaments.tournament.requirement.TournamentRequirement;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

@Getter
public class TournamentSettings {

    private final Tournament tournament;

    private final Map<TournamentSetting, Boolean> settings = new HashMap<>();

    private final List<TournamentRequirement> join = new ArrayList<>();

    public TournamentSettings(@NotNull final Tournament tournament){
        this.tournament = tournament;

        Arrays.stream(TournamentSetting.values())
                .forEach(value -> this.settings.put(value, false));
    }

    public boolean check(@NotNull final TournamentSetting setting){
        return this.settings.get(setting);
    }

    public boolean check(@NotNull final Player player){
        boolean check = true;

        for (TournamentRequirement requirement : this.join){
            if (!requirement.control(player))
                check = false;
        }

        return check;
    }
}
