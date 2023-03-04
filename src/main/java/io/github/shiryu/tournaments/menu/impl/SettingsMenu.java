package io.github.shiryu.tournaments.menu.impl;

import io.github.shiryu.tournaments.menu.Menu;
import io.github.shiryu.tournaments.util.FileLoader;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

public class SettingsMenu extends Menu {

    public SettingsMenu() {
        super(
                FileLoader.loadMenu("settings.yml")
        );
    }

}
