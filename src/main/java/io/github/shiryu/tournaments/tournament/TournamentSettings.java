package io.github.shiryu.tournaments.tournament;

import io.github.shiryu.tournaments.tournament.requirement.Requirement;
import io.github.shiryu.tournaments.tournament.reward.Reward;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@RequiredArgsConstructor
public class TournamentSettings {

    private final Tournament tournament;

    private boolean autoJoin;

    private final List<String> disabledWorlds = new ArrayList<>();

    private final List<Requirement> requirements = new ArrayList<>();

    private final Map<Integer, List<Reward>> rewards = new HashMap<>();

    private boolean active;

    private boolean repeat;

    private long start;
    private long finish;
}
