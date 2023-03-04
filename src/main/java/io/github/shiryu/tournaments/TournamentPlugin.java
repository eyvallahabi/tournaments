package io.github.shiryu.tournaments;

import com.cryptomorin.xseries.XMaterial;
import dev.rollczi.litecommands.LiteCommands;
import dev.rollczi.litecommands.bukkit.LiteBukkitFactory;
import dev.rollczi.litecommands.bukkit.tools.BukkitOnlyPlayerContextual;
import io.github.shiryu.tournaments.commands.TournamentsCommand;
import io.github.shiryu.tournaments.database.TournamentDatabase;
import io.github.shiryu.tournaments.files.TournamentFiles;
import io.github.shiryu.tournaments.menu.impl.ParentMenu;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class TournamentPlugin extends JavaPlugin {

    @Getter
    private static TournamentPlugin instance;

    private TournamentFiles files;
    private TournamentDatabase database;

    private LiteCommands<CommandSender> commands;

    @Override
    public void onEnable() {
        instance = this;

        this.files = new TournamentFiles(this);
        this.loadMenuFiles();

        this.database = new TournamentDatabase(this);
        this.database.connect();

        this.registerCommands();
    }

    private void loadMenuFiles(){
        new ParentMenu();
    }

    private void registerCommands(){
        this.commands = LiteBukkitFactory.builder(this.getServer(), "")
                .contextualBind(Player.class, new BukkitOnlyPlayerContextual<>("&cOnly a player can use this command!"))
                .command(TournamentsCommand.class)
                .register();
    }
}
