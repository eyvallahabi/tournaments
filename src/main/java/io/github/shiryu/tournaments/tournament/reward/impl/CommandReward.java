package io.github.shiryu.tournaments.tournament.reward.impl;

import io.github.shiryu.tournaments.tournament.requirement.annotation.RequirementInfo;
import io.github.shiryu.tournaments.tournament.reward.Reward;
import io.github.shiryu.tournaments.tournament.reward.annotation.RewardInfo;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@RewardInfo(id = "command")
public class CommandReward implements Reward {

    @Override
    public void give(@NotNull Player player, @NotNull List<String> args) {
        final StringBuilder sb = new StringBuilder();

        for (int i = 0; i < args.size(); i++){
            final String arg = args.get(i);

            if (i == (args.size() - 1)){
                sb.append(arg);
            }else{
                sb.append(arg + " ");
            }
        }

        try{
            Bukkit.dispatchCommand(
                    Bukkit.getConsoleSender(),
                    sb.toString()
            );
        }catch (final Exception exception){
            return;
        }
    }


}
