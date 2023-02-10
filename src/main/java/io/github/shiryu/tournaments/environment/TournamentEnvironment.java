package io.github.shiryu.tournaments.environment;

import io.github.shiryu.tournaments.environment.type.SenderType;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TournamentEnvironment {

    private CommandSender sender;
    private Player player;

    private SenderType type;

    private List<String> args = new ArrayList<>();

    @NotNull
    public String getArgsShaped(){
        final StringBuilder sb = new StringBuilder();

        for (final String arg : this.args){
            sb.append(
                    arg + " "
            );
        }

        return sb.toString();
    }
}
