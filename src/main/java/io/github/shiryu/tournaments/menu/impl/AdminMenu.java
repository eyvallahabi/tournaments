package io.github.shiryu.tournaments.menu.impl;

import io.github.shiryu.tournaments.menu.Menu;
import io.github.shiryu.tournaments.util.FileLoader;

public class AdminMenu extends Menu {

    public AdminMenu() {
        super(
                FileLoader.loadMenu("admin.yml")
        );
    }

}
