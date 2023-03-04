package io.github.shiryu.tournaments.files;

import io.github.shiryu.spider.configuration.base.BaseConfiguration;
import io.github.shiryu.spider.configuration.base.Configs;
import io.github.shiryu.tournaments.TournamentPlugin;
import io.github.shiryu.tournaments.files.impl.SettingsFile;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

@Getter
public class TournamentFiles {

    private final TournamentPlugin plugin;


    private final SettingsFile settings;

    public TournamentFiles(@NotNull final TournamentPlugin plugin) {
        this.plugin = plugin;

        this.settings = new SettingsFile();

        this.loadDefaultFiles(
                this.settings
        );
    }

    private void loadDefaultFiles(@NotNull final BaseConfiguration... configurations){
        Arrays.stream(configurations)
                .forEach(configuration ->
                        Configs.yaml(
                                new Configs.FileSettings(
                                        this.plugin,
                                        false,
                                        false
                                ),
                                configuration
                       )
                );
    }

}
