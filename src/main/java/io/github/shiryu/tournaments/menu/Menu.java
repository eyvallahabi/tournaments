package io.github.shiryu.tournaments.menu;

import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import io.github.shiryu.spider.configuration.yaml.YamlFile;
import org.jetbrains.annotations.NotNull;

public class Menu extends ChestGui {

    private final YamlFile file;

    public Menu(@NotNull final YamlFile file){
        super(
                file.load().get("rows", Integer.class).getOrSet(1),
                file.load().get("title", String.class).getOrSet("Loading")
        );

        this.file = file;
        this.file.load();
    }
}
