package io.github.shiryu.tournaments.menu.player;

import io.github.shiryu.spider.configuration.yaml.YamlFile;
import io.github.shiryu.tournaments.menu.Menu;
import org.jetbrains.annotations.NotNull;

public class PlayerParentMenu extends Menu {

    public PlayerParentMenu(){
        super(
                new YamlFile("player_parent.yml", "/menus")
        );
    }

    @Override
    public void fill() {

    }
}
