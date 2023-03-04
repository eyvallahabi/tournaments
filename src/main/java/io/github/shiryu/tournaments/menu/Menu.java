package io.github.shiryu.tournaments.menu;

import com.cryptomorin.xseries.XMaterial;
import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.Pane;
import com.github.stefvanschie.inventoryframework.pane.StaticPane;
import io.github.shiryu.spider.util.Colored;
import io.github.shiryu.spider.util.item.ItemBuilder;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class Menu extends ChestGui {

    private final FileConfiguration config;

    public Menu(@NotNull final FileConfiguration config) {
        super(config.getInt("rows"), Colored.convert(config.getString("title")));

        this.config = config;
    }

    @Override
    public void show(@NotNull HumanEntity humanEntity) {
        this.fill(((Player) humanEntity));

        super.show(humanEntity);
    }

    public void fill(@NotNull final Player player){

    }

    public void addItem(@NotNull final StaticPane pane, @NotNull final String name, @NotNull final Consumer<InventoryClickEvent> consumer){
        pane.addItem(
                create(
                        name,
                        consumer
                ),
                getX(name),
                getY(name)
        );
    }

    public int getX(@NotNull final String path){
        return this.config.getInt("items." + path + ".x");
    }

    public int getY(@NotNull final String path){
        return this.config.getInt("items." + path + ".y");
    }

    @NotNull
    public GuiItem create(@NotNull final String path, @NotNull final Consumer<InventoryClickEvent> consumer){
        return new GuiItem(
                this.getItem(path),
                consumer
        );
    }

    @NotNull
    public ItemStack getItem(@NotNull final String path){
        final String basePath = "items." + path + ".";

        return ItemBuilder.from(XMaterial.matchXMaterial(this.config.getString(basePath + "type")).orElse(XMaterial.PAPER))
                .name(this.config.getString(basePath + "name"))
                .lore(this.config.getStringList(basePath + "lore"))
                .build();
    }
}
