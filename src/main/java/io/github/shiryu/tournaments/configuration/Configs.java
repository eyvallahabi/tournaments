package io.github.shiryu.tournaments.configuration;

import io.github.shiryu.spider.config.BasicConfiguration;
import io.github.shiryu.spider.config.BasicFile;
import io.github.shiryu.spider.util.Colored;
import io.github.shiryu.tournaments.util.Replacer;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.UtilityClass;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;

@UtilityClass
public class Configs {

    @Getter
    private BasicConfiguration config;

    @Getter
    private BasicConfiguration messages;


    public void load(@NonNull final Plugin plugin){
        config = new BasicFile("config.yml", "")
                .loadDefaults(true)
                .create(plugin, false)
                .config();

        messages = new BasicFile("messages.yml", "")
                .loadDefaults(true)
                .create(plugin, false)
                .config();
    }

    public void sendMessage(@NonNull final CommandSender sender, @NonNull final String message, @NonNull final Replacer replacer){
        sender.sendMessage(
                Colored.convert(
                        replacer.replace(
                                messages.getOrSet(message, "")
                        )
                )
        );
    }

    public void sendMessage(@NonNull final CommandSender sender, @NonNull final String message){
        Configs.sendMessage(sender, message, new Replacer());
    }

    public void sendMessage(@NonNull final Player player, @NonNull final String message, @NonNull final Replacer replacer){
        Configs.sendMessage(
                (CommandSender) player,
                message,
                replacer
        );
    }

    public void sendMessage(@NonNull final Player player, @NonNull final String message){
        Configs.sendMessage(
                player,
                message,
                new Replacer()
        );
    }

    public void loadAll(){
        load(
                config,
                messages
        );
    }

    private void load(@NonNull final BasicConfiguration... configs){
        Arrays.stream(configs)
                .forEach(BasicConfiguration::load);
    }
}
