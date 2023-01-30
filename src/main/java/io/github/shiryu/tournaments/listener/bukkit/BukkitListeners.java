package io.github.shiryu.tournaments.listener.bukkit;

import lombok.experimental.UtilityClass;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

@UtilityClass
public class BukkitListeners {

    @NotNull
    public <T extends Event> BukkitListener<T> newListener(@NotNull final Class<T> clazz, @NotNull final Consumer<T> consumer){
        return new BukkitListener<>() {
            @Override
            public void listen(@NotNull T event) {
                consumer.accept(
                        event
                );
            }

            @Override
            public @NotNull Class<T> getEventClass() {
                return clazz;
            }
        };
    }
}
