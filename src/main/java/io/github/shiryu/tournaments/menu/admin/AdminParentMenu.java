package io.github.shiryu.tournaments.menu.admin;

import io.github.shiryu.spider.configuration.yaml.YamlFile;
import io.github.shiryu.tournaments.menu.Menu;

public class AdminParentMenu extends Menu {

    public AdminParentMenu(){
        super(
                new YamlFile("admin_parent.yml", "/menus")
        );
    }

    @Override
    public void fill() {

    }
}
