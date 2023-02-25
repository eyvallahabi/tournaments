package io.github.shiryu.tournaments.menu;

import com.cryptomorin.xseries.XMaterial;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import io.github.shiryu.spider.configuration.yaml.YamlFile;
import io.github.shiryu.spider.util.item.ItemBuilder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

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

    public void fill(){

    }

    public ItemStack getItem(@NotNull final String path){
        return ItemBuilder.from(XMaterial.matchXMaterial(this.file.load()
                .get(path + ".type", String.class).getOrSet("PAPER")).orElse(XMaterial.PAPER))
                .name(this.file.load().get(path + ".name", String.class).getOrSet(""))
                .lore(this.file.load().get(path + ".lore", List.class).getOrSet(new ArrayList<>()))
                .build();
    }
}
