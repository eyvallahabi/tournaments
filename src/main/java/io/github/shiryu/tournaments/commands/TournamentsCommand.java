package io.github.shiryu.tournaments.commands;

import dev.rollczi.litecommands.command.execute.Execute;
import dev.rollczi.litecommands.command.route.Route;
import io.github.shiryu.tournaments.menu.impl.ParentMenu;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Route(name = "tournaments")
public class TournamentsCommand {

    @Execute
    public void help(@NotNull final CommandSender sender){

    }

    @Execute(route = "menu")
    public void menu(final Player sender){
        new ParentMenu().show(sender);
    }
}