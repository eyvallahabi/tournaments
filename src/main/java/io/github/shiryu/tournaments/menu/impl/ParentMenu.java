package io.github.shiryu.tournaments.menu.impl;

import com.github.stefvanschie.inventoryframework.pane.StaticPane;
import com.github.stefvanschie.inventoryframework.pane.util.Slot;
import io.github.shiryu.tournaments.menu.Menu;
import io.github.shiryu.tournaments.util.FileLoader;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class ParentMenu extends Menu {

    public ParentMenu(){
        super(
                FileLoader.loadMenu(
                        "parent.yml"
                )
        );
    }

    @Override
    public void fill(@NotNull final Player player) {
        final StaticPane pane = new StaticPane(9, this.getRows());

        this.setOnGlobalClick(event -> event.setCancelled(true));

        this.addItem(pane, "ongoing", event ->{

        });

        this.addItem(pane, "stats", event ->{

        });

        this.addItem(pane, "settings", event ->{

        });

        this.addPane(pane);
        this.addAdminPane(player);
    }

    private void addAdminPane(@NotNull final Player player){
        final StaticPane admin = new StaticPane(getX("admin"), getY("admin"), 1, 1);

        admin.addItem(
                create(
                        "admin",
                        (event ->{

                        })
                ),
                0,
                0
        );

        this.addPane(admin);

        if (!player.hasPermission("tournaments.admin"))
            admin.setVisible(false);
    }
}
