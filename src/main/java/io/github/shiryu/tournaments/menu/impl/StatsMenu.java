package io.github.shiryu.tournaments.menu.impl;

import io.github.shiryu.tournaments.menu.Menu;
import io.github.shiryu.tournaments.util.FileLoader;

public class StatsMenu extends Menu {

    public StatsMenu() {
        super(
                FileLoader.loadMenu("stats.yml")
        );
    }

}
