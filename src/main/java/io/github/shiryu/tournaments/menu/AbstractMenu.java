package io.github.shiryu.tournaments.menu;

import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractMenu extends ChestGui {

    //TODO files and stuff.

    public AbstractMenu(final int row, @NotNull final String title){
        super(row, title);
    }

}
