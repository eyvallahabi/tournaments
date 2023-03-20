package io.github.shiryu.tournaments;

import dev.rollczi.litecommands.LiteCommands;
import dev.rollczi.litecommands.bukkit.LiteBukkitFactory;
import dev.rollczi.litecommands.bukkit.tools.BukkitOnlyPlayerContextual;
import io.github.shiryu.tournaments.commands.TournamentsCommand;
import io.github.shiryu.tournaments.database.TournamentDatabase;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

@Getter
public class TournamentPlugin extends JavaPlugin {

    @Getter
    private static TournamentPlugin plugin;

    private TournamentDatabase database;

    private LiteCommands<CommandSender> commands;

    @Override
    public void onEnable() {
        plugin = this;

        this.database = new TournamentDatabase(this);
        this.database.connect();

        this.registerCommands();
    }

    private void registerCommands(){
        this.commands = LiteBukkitFactory.builder(this.getServer(), "")
                .contextualBind(Player.class, new BukkitOnlyPlayerContextual<>("&cOnly a player can use this command!"))
                .command(TournamentsCommand.class)
                .register();
    }
}
