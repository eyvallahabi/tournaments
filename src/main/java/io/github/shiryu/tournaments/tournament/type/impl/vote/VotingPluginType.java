package io.github.shiryu.tournaments.tournament.type.impl.vote;

import com.bencodez.votingplugin.events.PlayerVoteEvent;
import io.github.shiryu.tournaments.listener.bukkit.BukkitListeners;
import io.github.shiryu.tournaments.tournament.type.TournamentType;

public class VotingPluginType extends TournamentType {

    public VotingPluginType(){
        register(
                BukkitListeners.newListener(
                        PlayerVoteEvent.class,
                        (event -> findAndUpdate(event.getVotingPluginUser().getPlayer()))
                )
        );
    }
}
