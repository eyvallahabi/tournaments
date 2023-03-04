package io.github.shiryu.tournaments.menu.impl;

import io.github.shiryu.tournaments.menu.Menu;
import io.github.shiryu.tournaments.util.FileLoader;

public class OngoingMenu extends Menu {

    public OngoingMenu() {
        super(
                FileLoader.loadMenu("ongoing.yml")
        );
    }

}
